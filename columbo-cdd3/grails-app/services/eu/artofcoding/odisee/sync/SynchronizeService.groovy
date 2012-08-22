/*
 * Odisee Sync
 *
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.odisee.sync

import groovy.sql.Sql
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.commons.GrailsApplication
import java.sql.Timestamp

/**
 *
 */
class SynchronizeService {

    /**
     * GrailsApplication.
     */
    GrailsApplication grailsApplication

    /**
     * ISO date format.
     */
    private static SimpleDateFormat isoDate = new SimpleDateFormat("yyyyMMdd")

    /**
     * ISO date format with time.
     */
    private static SimpleDateFormat mysqlIsoDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm")

    /**
     * German date format with hour and minute.
     */
    private static SimpleDateFormat lastSyncDate = new SimpleDateFormat("dd.MM.yyyy HH:mm")

    /**
     * SQL Server can store dates starting at 01.01.1753 only.
     */
    private static Timestamp sqlServerMinimumTimestamp = new Timestamp(-147, 0, 1, 0, 0, 0, 0)

    /**
     * Default fetch size (how many rows to fetch?).
     */
    private static int defaultFetchSize = 100

    /**
     * Default row count for commits.
     */
    private static int defaultCommitRows = 100

    /**
     * Get last synchronisation date of a table.
     * @param project
     * @param table
     * @return
     */
    public Date getLastSync(String project, String table) {
        Calendar cal = Calendar.instance
        File f = new File('odisync-config.groovy')
        // Create empty file it it does not exist
        if (!f.exists()) {
            f.withWriter { writer ->
                writer.write('odisync=[:]')
            }
        }
        // Parse file
        ConfigObject config = new ConfigSlurper().parse(f.toURL())
        try {
            // Get map with information about table
            def tableConfig = config.odisync[project][table]
            // Create information if it does not exist
            if (!tableConfig) {
                tableConfig = ['lastSync': // ... so lastSync is 'now'
                        [
                                year: cal.get(Calendar.YEAR),
                                month: cal.get(Calendar.MONTH) + 1,
                                day: cal.get(Calendar.DAY_OF_MONTH),
                                hour: cal.get(Calendar.HOUR_OF_DAY),
                                minute: cal.get(Calendar.MINUTE)
                        ]
                ]
            }
            // Get map with last sync date
            def lastSync = tableConfig.'lastSync'
            lastSync.with {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month - 1)
                cal.set(Calendar.DAY_OF_MONTH, day)
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                cal.set(Calendar.SECOND, 0)
            }
        } catch (e) {
            throw e
            // ignore
        }
        cal.time
    }

    /**
     * Set last synchronization date for a table.
     * @param project
     * @param table
     * @param lastSync
     */
    private void setLastSync(String project, String table, Calendar cal) {
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        //
        cal.add(Calendar.SECOND, (int) _project.timeout * 2)
        // Last sync cannot be in the future
        Calendar now = Calendar.instance
        if (cal.after(now)) {
            cal = now
        }
        // Update file
        File f = new File('odisync-config.groovy')
        ConfigObject config = new ConfigSlurper().parse(f.toURL())
        // Set date/time in ConfigObject and write file
        try {
            if (!_project.containsKey(table)) {
                _project[table] = [:]
            }
            config.odisync[project][table].'lastSync' = [
                    year: cal.get(Calendar.YEAR),
                    month: cal.get(Calendar.MONTH) + 1,
                    day: cal.get(Calendar.DAY_OF_MONTH),
                    hour: cal.get(Calendar.HOUR_OF_DAY),
                    minute: cal.get(Calendar.MINUTE)
            ]
            f.withWriter { writer ->
                config.writeTo(writer)
            }
        } catch (e) {
            throw e
        }
    }

    /**
     * Build connection string, a JDBC URL.
     * @param project
     * @param connection
     * @return String A JDBC URL.
     */
    private String makeConnectionString(String project, String connection) {
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // Get the connection entry
        def _connection = _project.'connection'[connection]
        // Construct JDBC URL
        switch (_connection.type) {
            case 'Oracle':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 1521
                // SID return "jdbc:oracle:thin:@${host}:${port}:${_connection.database}"
                // SERVICE_NAME
                return "jdbc:oracle:thin:@//${host}:${port}/${_connection.database}"
                break
            case 'SQL Server':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 1433
                return "jdbc:jtds:sqlserver://${host}:${port};databaseName=${_connection.database}"
                break
            case 'MySQL':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 3306
                return "jdbc:mysql://${host}:${port}/${_connection.database}"
                break
        }
    }

    /**
     * Connect to a database.
     * @param project
     * @param connection
     * @return groovy.sql.Sql
     */
    public Sql connect(String project, String connection) {
        def url = makeConnectionString(project, connection)
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // Get connection entry
        def _connection = _project.'connection'[connection]
        // Connect
        String driver
        switch (_connection.type) {
            case 'Oracle':
                driver = _connection.driver.toString() ?: 'oracle.jdbc.driver.OracleDriver'
                break
            case 'SQL Server':
                driver = _connection.driver.toString() ?: 'net.sourceforge.jtds.jdbc.Driver'
                break
            case 'MySQL':
                driver = _connection.driver.toString() ?: 'com.mysql.jdbc.Driver'
                break
            default:
                driver = 'unknown'
        }
        Sql.newInstance(url, _connection.user.toString(), _connection.pwd.toString() ?: '', driver)
    }

    /**
     * Create table in a certain database like defined in configuration.
     * @param project
     * @param connection
     * @param table
     * @return
     */
    private String createTable(String project, String connection, String table) {
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // The table configuration
        def _table = _project.'table'[table]
        // Table's columns as SQL DDL: NAME TYPE(PREC...)
        String columns = _table.columns.collect { it.key + ' ' + it.value.type }.join(', ')
        // Create temporary table, name: <schema>.<table>_<date>_<random number>
        String today = isoDate.format(new Date())
        String rand = String.format('%06.0f', Math.random() * 100000)
        // Make table name... include schema?
        StringBuilder builder = new StringBuilder()
        if (_table.destination_database) {
            builder << "${_table.destination_database}."
        }
        if (_table.destination_schema) {
            builder << "${_table.destination_schema}."
        }
        builder << "${table}_${today}_${rand}"
        String tableName = builder.toString()
        // CREATE TABLE
        String stmt = "CREATE TABLE ${tableName} (${columns})"
        log.debug "copyTable(${project}, ${table}): ${stmt}"
        def _connection = connect(project, connection)
        _connection.execute(stmt)
        // Return name of temporary table
        return tableName
    }

    /**
     * Remove a table in a certain database.
     * @param project
     * @param connection
     * @param tableName Name of table, may include '<schema>.'
     * @return
     */
    public void removeTable(String project, String connection, String tableName) {
        /*
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // The table configuration
        def _table = _project.'table'[tableName]
        */
        // TRUNCATE, DROP TABLE
        def _connection = connect(project, connection)
        ["TRUNCATE TABLE ${tableName}", "DROP TABLE ${tableName}"].each { stmt ->
            log.debug "removeTable(${project}, ${tableName}): ${stmt}"
            _connection.execute(stmt.toString())
        }
        _connection.close()
    }

    /**
     *
     * @param stmt
     */
    private void commitBatch(Statement stmt) {
        stmt.executeBatch()
        stmt.connection.commit()
        stmt.clearBatch()
    }

    /**
     * Copy a table from database connection 'source' to database connection 'destination'.
     * @param project
     * @param table
     * @return Map , table: String Name of temporary table, rowCount: Count of synced rows.
     */
    public Map copyTable(String project, String table) {
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // Get table configuration
        def _table = _project.'table'[table]
        // Create temporary table in destination database
        String temporaryTableName = createTable(project, 'destination', table)
        // Return map
        Map map = [table: temporaryTableName, rowCount: -1]
        // Build SELECT statement
        StringBuilder stmt = new StringBuilder()
        // Table's columns as string, separated with comma
        String columns = _table.columns.collect { it.key }.join(', ')
        stmt << "SELECT ${columns} FROM ${table}"
        // since_last_sync mode?
        Calendar cal = setDatesInStatement(project, table, stmt)
        log.debug "copyTable(${project}, ${table}): ${stmt.toString()}"
        // Connect to source database
        Sql source = connect(project, 'source')
        // Connect to destination database
        Sql destination = connect(project, 'destination')
        // Prepare statement
        PreparedStatement selectStmt = source.connection.prepareStatement(stmt.toString())
        selectStmt.setFetchSize(_table.fetchSize ?: defaultFetchSize)
        selectStmt.setFetchDirection(ResultSet.FETCH_FORWARD)
        // Copy data
        int rowCount = 0 // Row counter
        int batchStmtCount = 0 // Count statements per batch
        PreparedStatement insertStmt = null
        Map __actualRow = [:]
        Object __v
        try {
            // Disable auto commit
            destination.connection.autoCommit = false
            // Create INSERT statement
            stmt.delete(0, stmt.length())
            stmt << "INSERT INTO ${temporaryTableName} (${columns}) VALUES ("
            stmt << _table.columns.collect { col -> '?' }.join(', ')
            stmt << ")"
            log.debug "copyTable(${project}, ${table}): ${stmt.toString()}"
            insertStmt = destination.connection.prepareStatement(stmt.toString())
            // Execute SELECT and fill batch for INSERTing data
            ResultSet resultSet = selectStmt.executeQuery()
            int commitRows = _table.commitRows ?: defaultCommitRows
            while (resultSet.next()) {
                // Copy column(s)
                _table.columns.eachWithIndex { Map.Entry col, int i ->
                    __v = resultSet.getObject((String) col.key)
                    // Check value
                    if (__v instanceof Timestamp) {
                        Timestamp ts = (Timestamp) __v
                        if (ts.before(sqlServerMinimumTimestamp)) {
                            __v = sqlServerMinimumTimestamp
                        }
                    }
                    // Save actual row for catch-block below
                    __actualRow[col.key] = __v
                    // Set value in INSERT statement
                    insertStmt.setObject(i + 1, __v)
                }
                // Add statement to batch
                batchStmtCount++
                insertStmt.addBatch()
                // Commit every N rows
                if (rowCount > 0 && rowCount % commitRows == 0) {
                    log.info "copyTable(${project}, ${table}): Committing ${commitRows} rows (${rowCount} total) to ${temporaryTableName}"
                    commitBatch(insertStmt)
                    batchStmtCount = 0
                }
                // Increase row counter
                rowCount++
                // Clear __actualRow map
                __actualRow.clear()
            }
            // Last commit
            log.info "copyTable(${project}, ${table}): Committing ${batchStmtCount} rows (${rowCount} total) to ${temporaryTableName}"
            commitBatch(insertStmt)
            // Set last sync
            setLastSync(project, table, cal)
            // Return temporary table name
            map.rowCount = rowCount
        } catch (Exception e) {
            StringBuilder builder = new StringBuilder()
            builder << __actualRow?.collect { k, v -> "${k} = ${v}" }?.join(', ')
            log.error "Cannot process batch with ${rowCount} rows, row data: ${builder.toString()}", e
            map.rowCount = -1
        } finally {
            // Cleanup
            try {
                source?.close()
                destination?.close()
            } catch (SQLException e) {
                // ignore
            }
        }
        return map
    }

    /**
     * We sync "from last time we synced upto +timeout".
     * @param _project
     * @param _table
     * @param stmt StringBuilder SQL WHERE will be added to this instance.
     * @return Calendar Instance of calendar with computed dates or 'now' when mode 'since_last_sync' is not configured.
     */
    private Calendar setDatesInStatement(project, table, StringBuilder stmt) {
        // Project configuration
        def _project = grailsApplication.config.'odisync'[project]
        // Get table configuration
        def _table = _project.'table'[table]
        Calendar cal = Calendar.instance // now
        if (_table.where?.mode == 'since_last_sync') {
            // Get date/time of last sync
            Date lastSync = getLastSync(project, table)
            // Substract job timeout
            cal = Calendar.instance
            cal.setTime(lastSync)
            cal.add(Calendar.SECOND, (int) _project.timeout * -1)
            // Generate strings for SQL WHERE
            String betweenLastSync
            String betweenLastSyncMinusTimeout
            switch (_project.connection.source.type) {
            // Oracle
                case 'Oracle':
                    betweenLastSync = "TO_DATE('${lastSyncDate.format(lastSync)}', 'DD.MM.YYYY HH24:MI')"
                    betweenLastSyncMinusTimeout = "TO_DATE('${lastSyncDate.format(cal.time)}', 'DD.MM.YYYY HH24:MI')"
                    break
            // MySQL
                case 'MySQL':
                    betweenLastSync = "'${mysqlIsoDateTime.format(lastSync)}'"
                    betweenLastSyncMinusTimeout = "'${mysqlIsoDateTime.format(cal.time)}'"
                    break
            }
            // Build WHERE condition
            stmt << ' WHERE '
            stmt << _table.where.column << ' BETWEEN ' << betweenLastSyncMinusTimeout << ' AND ' << betweenLastSync
            //log.debug "setDatesInStatement(${project}, ${table}): WHERE ${_table.where.column} BETWEEN ${betweenLastSyncMinusTimeout} AND ${betweenLastSync}"
        }
        return cal
    }

}
