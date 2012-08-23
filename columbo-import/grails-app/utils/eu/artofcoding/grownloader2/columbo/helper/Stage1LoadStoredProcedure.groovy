/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.corma.columbo.helper

import java.sql.ResultSet
import java.sql.SQLException
import javax.sql.DataSource
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.SqlParameter
import org.springframework.jdbc.core.SqlReturnResultSet
import org.springframework.jdbc.object.StoredProcedure

/**
 * Multiton, combined with double-checked locking.
 * Class to call stored procedures to load data into stage 1.
 */
class Stage1LoadStoredProcedure extends StoredProcedure {
    
    /**
     * Map to cache generated instances.
     */
    private static final Map INSTANCE = [:]
    
    /**
     * 
     */
    /*
    class CaseEnd2EndRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null
        }
    }
    */
    
    /**
     * Multiton: save one instance per 'schemaAndProcedureName'.
     * @param schemaAndProcedureName Qualified name of stored procedures, e.g. schema.p_name.
     * @param dataSource javax.sql.DataSource.
     * @return Stage1LoadStoredProcedure
     */
    static Stage1LoadStoredProcedure getInstance(String schemaAndProcedureName, DataSource dataSource) {
        Stage1LoadStoredProcedure instance = INSTANCE.get(schemaAndProcedureName)
        if (null == instance) {
            synchronized (INSTANCE) {
                if (!INSTANCE.containsKey(schemaAndProcedureName)) {
                    instance = INSTANCE[schemaAndProcedureName] = new Stage1LoadStoredProcedure(schemaAndProcedureName, dataSource)
                }
            }
        }
        println "${schemaAndProcedureName}: using instance ${instance}"
        return instance
    }
    
    /**
     * Create new instance.
     * @param schemaAndProcedureName Qualified name of stored procedures, e.g. schema.p_name.
     * @param dataSource javax.sql.DataSource.
     */
    private Stage1LoadStoredProcedure(String schemaAndProcedureName, DataSource dataSource) {
        super(dataSource, schemaAndProcedureName)
        /*
        setFunction true
        declareParameter(new SqlReturnResultSet('rs', new CaseEnd2EndRowMapper()))
        */
        declareParameter(new SqlParameter('file', java.sql.Types.VARCHAR))
        declareParameter(new SqlParameter('formatfile', java.sql.Types.VARCHAR))
        declareParameter(new SqlParameter('temp_table_name', java.sql.Types.VARCHAR))
        compile()
    }
    
    /**
     * Execute stored procedure.
     * @param filename Name of the file to import.
     * @param formatFilename Name of the format file to use for import file.
     * @return Map
     */
    public Map execute(String filename, String formatFilename, String tempTableName) {
        def m = [file: filename, formatfile: formatFilename, temp_table_name: tempTableName]
        println "execute: ${m}"
        return super.execute(m)
    }
    
}
