/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 10:46 AM
 */

package eu.artofcoding.grownloader.columbo;

import eu.artofcoding.grownloader.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Stage2Merger implements Tasklet {

    @Slf4j
    private static Logger logger;

    private String tableName;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;
    
    private String procedureName;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Call stored proc
        final String storedProc = String.format("{call %s(?, ?)}", procedureName);
        logger.info(String.format("[%s] Merging new data through %s(%s, %s)", tableName, storedProc, tableName, tableName));
        logger.info(String.format("[%s] Merged %n rows", jdbcTemplate.update(storedProc, tableName, tableName)));
        return RepeatStatus.FINISHED;
    }

}
