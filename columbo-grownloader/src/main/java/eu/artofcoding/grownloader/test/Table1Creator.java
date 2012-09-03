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

package eu.artofcoding.grownloader.test;

import eu.artofcoding.grownloader.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Table1Creator implements Tasklet {

    @Slf4j
    private static Logger logger;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try {
            jdbcTemplate.execute("SELECT * FROM table1 WHERE 1 = 0");
        } catch (DataAccessException e) {
            logger.info("Creating table table1");
            jdbcTemplate.execute("CREATE TABLE table1 (id INT, customer VARCHAR(100), bla DATETIME, blub DATETIME, another_data VARCHAR(100))");
        }
        return RepeatStatus.FINISHED;
    }

}
