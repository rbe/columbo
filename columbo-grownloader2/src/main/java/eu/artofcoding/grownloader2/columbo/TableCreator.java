/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 10:39 AM
 */

package eu.artofcoding.grownloader2.columbo;

import eu.artofcoding.grownloader2.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TableCreator implements Tasklet {

    @Slf4j
    private static Logger logger;

    private String procedureName;

    private String schemaName;

    private String tableName;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // If table exists truncate its contents, otherwise create it through stored procedure
        try {
            //jdbcTemplate.execute(String.format("SELECT * FROM %s.%s WHERE 1 = 0", schemaName, tableName));
            jdbcTemplate.execute(String.format("TRUNCATE TABLE %s.%s", schemaName, tableName));
        } catch (DataAccessException e) {
            final String storedProc = String.format("{call %s(?, ?)}", procedureName);
            logger.info("Creating destination table through stored procedure " + storedProc, e);
            jdbcTemplate.update(storedProc, schemaName, tableName);
        }
        return RepeatStatus.FINISHED;
    }

}
