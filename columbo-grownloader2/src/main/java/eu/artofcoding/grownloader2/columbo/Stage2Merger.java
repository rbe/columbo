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

package eu.artofcoding.grownloader2.columbo;

import eu.artofcoding.grownloader2.spring.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /*
    private class Csc implements CallableStatementCreator {
        @Override
        public CallableStatement createCallableStatement(Connection con) throws SQLException {
            CallableStatement callableStatement = con.prepareCall("call stage2.p_merge(?, ?)");
            return callableStatement;
        }
    }
    */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        logger.info(String.format("Merging stage1 into stage2 for %s on %s", tableName, dataSource));
        // Call stored proc
        /*
        CallableStatementCreator csc = new Csc();
        List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
        declaredParameters.add(new SqlParameter("target_table", Types.VARCHAR));
        declaredParameters.add(new SqlParameter("source_table", Types.VARCHAR));
        jdbcTemplate.call(csc, declaredParameters);
        */
        jdbcTemplate.update("{call stage2.p_merge(?, ?)}", tableName, tableName); // TODO p_merge_all?
        return RepeatStatus.FINISHED;
    }

}
