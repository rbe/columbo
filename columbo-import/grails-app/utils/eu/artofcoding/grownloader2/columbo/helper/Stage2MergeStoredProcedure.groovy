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
 * Class to call stored procedures to merge data into stage 2.
 */
class Stage2MergeStoredProcedure extends StoredProcedure {
    
    /**
     * Map to cache generated instances.
     */
    private static final Map INSTANCE = [:]
    
    /**
     * Multiton: save one instance per 'schemaAndProcedureName'.
     * @param schemaAndProcedureName Qualified name of stored procedures, e.g. schema.p_name.
     * @param dataSource javax.sql.DataSource.
     * @return Stage2MergeStoredProcedure
     */
    static Stage2MergeStoredProcedure getInstance(String schemaAndProcedureName, DataSource dataSource) {
        Stage2MergeStoredProcedure instance = INSTANCE.get(schemaAndProcedureName)
        if (null == instance) {
            synchronized (INSTANCE) {
                if (!INSTANCE.containsKey(schemaAndProcedureName)) {
                    instance = INSTANCE[schemaAndProcedureName] = new Stage2MergeStoredProcedure(schemaAndProcedureName, dataSource)
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
    private Stage2MergeStoredProcedure(String schemaAndProcedureName, DataSource dataSource) {
        super(dataSource, schemaAndProcedureName)
        /*
        setFunction true
        declareParameter(new SqlReturnResultSet('rs', new CaseEnd2EndRowMapper()))
        */
        declareParameter(new SqlParameter('target_table', java.sql.Types.VARCHAR))
        declareParameter(new SqlParameter('source_table', java.sql.Types.VARCHAR))
        compile()
    }
    
    /**
     * Execute stored procedure.
     * @param filename Name of the file to import.
     * @param formatFilename Name of the format file to use for import file.
     * @return Map
     */
    public Map execute(String targetTable, String sourceTable) {
        def m = [target_table: targetTable, source_table: sourceTable]
        println "execute: ${m}"
        return super.execute(m)
    }
    
}
