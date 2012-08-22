/*
 * Grownloader
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.gronwloader

import groovy.sql.Sql
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.*

/**
 *
 */
class Synchronizer {

    /**
     * Logger.
     */
    private static Logger log = LoggerFactory.getLogger(Synchronizer.class)

    /**
     * Grownloader's configuration.
     */
    private static Gronfig config = Gronfig.instance

    /**
     * Get last synchronisation date of a table.
     * @param project
     * @param table
     * @return
     */
    public java.util.Date getLastSync(String project, String table) {
        Calendar cal = Calendar.instance
        File f = new File('grownloader-state.groovy')
        // Create empty file it it does not exist
        if (!f.exists()) {
            f.withWriter { writer ->
                writer.write('grownloader=[:]')
            }
        }
        // Parse file
        ConfigObject config = new ConfigSlurper().parse(f.toURL())
        try {
            // Get map with information about table
            def tableConfig = config.grownloader[project][table]
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
     * @param projectName
     * @param tableName
     * @param lastSync
     */
    private void setLastSync(String projectName, String tableName, Calendar cal) {
        // Project configuration
        def _project = config.'grownloader'[projectName]
        //
        cal.add(Calendar.SECOND, (int) _project.timeout * 2)
        // Last sync cannot be in the future
        Calendar now = Calendar.instance
        if (cal.after(now)) {
            cal = now
        }
        // Update file
        File f = new File('grownloader-state.groovy')
        ConfigObject config = new ConfigSlurper().parse(f.toURL())
        // Set date/time in ConfigObject and write file
        try {
            if (!_project.containsKey(tableName)) {
                _project[tableName] = [:]
            }
            config.grownloader[projectName][tableName].'lastSync' = [
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
     * We sync "from last time we synced upto +timeout".
     * @param _project
     * @param _table
     * @param stmt StringBuilder SQL WHERE will be added to this instance.
     * @return Calendar Instance of calendar with computed dates or 'now' when mode 'since_last_sync' is not configured.
     */
    private Calendar setDatesInStatement(String projectName, String tableName, StringBuilder stmt) {
        // Project configuration
        def _project = config.'grownloader'[projectName]
        def _table = _project.'table'[tableName]
        Calendar cal = Calendar.instance // now
        if (_table.where?.mode == 'since_last_sync') {
            // Get date/time of last sync
            java.util.Date lastSync = getLastSync(projectName, tableName)
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
                    betweenLastSync = "TO_DATE('${Gronstants.lastSyncDate.format(lastSync)}', 'DD.MM.YYYY HH24:MI')"
                    betweenLastSyncMinusTimeout = "TO_DATE('${Gronstants.lastSyncDate.format(cal.time)}', 'DD.MM.YYYY HH24:MI')"
                    break
            // MySQL
                case 'MySQL':
                    betweenLastSync = "'${Gronstants.mysqlIsoDateTime.format(lastSync)}'"
                    betweenLastSyncMinusTimeout = "'${Gronstants.mysqlIsoDateTime.format(cal.time)}'"
                    break
            }
            // Build WHERE condition
            stmt << ' WHERE '
            List tableList = _table.where.column
            tableList.eachWithIndex { t, i ->
                if (i > 0) stmt << ' OR '
                stmt << t << ' BETWEEN ' << betweenLastSyncMinusTimeout << ' AND ' << betweenLastSync
            }
            //log.debug "setDatesInStatement(${project}, ${table}): WHERE ${_table.where.column} BETWEEN ${betweenLastSyncMinusTimeout} AND ${betweenLastSync}"
        }
        return cal
    }

    /**
     * Build connection string, a JDBC URL.
     * @param project
     * @param connection
     * @return String A JDBC URL.
     */
    private String makeConnectionString(String project, String connection) {
        // Project configuration
        def _project = config.'grownloader'[project]
        // Get the connection entry
        def _connection = _project.'connection'[connection]
        // Construct JDBC URL
        String ret = null
        switch (_connection.type) {
            case 'Oracle':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 1521
                // SID return "jdbc:oracle:thin:@${host}:${port}:${_connection.database}"
                // SERVICE_NAME
                ret = "jdbc:oracle:thin:@//${host}:${port}/${_connection.database}"
                break
            case 'SQL Server':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 1433
                ret = "jdbc:jtds:sqlserver://${host}:${port};databaseName=${_connection.database}"
                break
            case 'MySQL':
                String host = _connection.host ?: 'localhost'
                int port = _connection.port ?: 3306
                ret = "jdbc:mysql://${host}:${port}/${_connection.database}"
                break
        }
        ret
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
        def _project = config.'grownloader'[project]
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
        def _project = config.'grownloader'[project]
        // The table configuration
        def _table = _project.'table'[table]
        // Table's columns as SQL DDL: NAME TYPE(PREC...)
        String columns = _table.columns.collect { it.key + ' ' + it.value.type }.join(', ')
        // Create temporary table, name: <schema>.<table>_<date>_<random number>
        String today = Gronstants.isoDate.format(new java.util.Date())
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
     * @param projectName
     * @param connection
     * @param tableName Name of table, may include '<schema>.'
     * @return
     */
    public void removeTable(String projectName, String connection, String tableName) {
        // TRUNCATE, DROP TABLE
        def _connection = connect(projectName, connection)
        ["TRUNCATE TABLE ${tableName}", "DROP TABLE ${tableName}"].each { stmt ->
            log.debug "removeTable(${projectName}, ${tableName}): ${stmt}"
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
        def _project = config.'grownloader'[project]
        // Get table configuration
        def _table = _project.'table'[table]
        // Return map
        Map map = [table: null, rowCount: -1]
        // Database connections
        Sql source = null
        Sql destination = null
        try {
            // Create temporary table in destination database
            String temporaryTableName = createTable(project, 'destination', table)
            map.table = temporaryTableName
            // Build SELECT statement
            StringBuilder stmt = new StringBuilder()
            // Table's columns as string, separated with comma
            String columns = _table.columns.collect { it.key }.join(', ')
            stmt << "SELECT ${columns} FROM ${table}"
            // since_last_sync mode?
            Calendar cal = setDatesInStatement(project, table, stmt)
            log.debug "copyTable(${project}, ${table}): ${stmt.toString()}"
            // Connect to source database
            source = connect(project, 'source')
            // Connect to destination database
            destination = connect(project, 'destination')
            // Prepare statement
            PreparedStatement selectStmt = source.connection.prepareStatement(stmt.toString())
            selectStmt.setFetchSize(_table.fetchSize ?: Gronstants.defaultFetchSize)
            selectStmt.setFetchDirection(ResultSet.FETCH_FORWARD)
            // Copy data
            int rowCount = 0 // Row counter
            int batchStmtCount = 0 // Count statements per batch
            PreparedStatement insertStmt = null
            Map __actualRow = [:]
            Object __v
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
            int commitRows = _table.commitRows ?: Gronstants.defaultCommitRows
            while (resultSet.next()) {
                // Copy column(s)
                _table.columns.eachWithIndex { Map.Entry col, int i ->
                    __v = resultSet.getObject((String) col.key)
                    // Check value
                    if (__v instanceof Timestamp) {
                        Timestamp ts = (Timestamp) __v
                        if (ts.before(Gronstants.sqlServerMinimumTimestamp)) {
                            __v = Gronstants.sqlServerMinimumTimestamp
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
            return map
        }
    }

    /**
     * Merge data from temporary table into another table.
     * @param projectName
     * @param sourceTableName
     * @param syncResult
     */
    public boolean mergeTable(String projectName, String sourceTableName, Map syncResult) {
        log.info "mergeTable(${projectName}, ${sourceTableName}): Merging table ${sourceTableName} to ${syncResult.table}"
        // Connect to destination database
        Sql conn = connect(projectName, 'destination')
        // Prepare call
        CallableStatement stage2MergeAll = conn.connection.prepareCall('{CALL stage2.p_merge_all(?, ?)}')
        // @target_table
        stage2MergeAll.setString(1, sourceTableName)
        // @source_table
        final String __t = (String) syncResult.table // Name of temporary table
        stage2MergeAll.setString(2, __t.split('[.]')[-1])
        // Execute stored procedure
        final resultFromStage2MergeAll = stage2MergeAll.execute()
        // Log and return result
        log.info "mergeTable(${projectName}, ${sourceTableName}): ${resultFromStage2MergeAll}"
        resultFromStage2MergeAll
    }

}
