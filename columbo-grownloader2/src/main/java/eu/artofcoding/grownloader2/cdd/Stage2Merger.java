package eu.artofcoding.grownloader2.cdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Stage2Merger implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(Stage2Merger.class.getName());

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
        logger.info("Merging stage1 into stage2 for " + tableName + " on " + dataSource);
        // Call stored proc
        /*
        CallableStatementCreator csc = new Csc();
        List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
        declaredParameters.add(new SqlParameter("target_table", Types.VARCHAR));
        declaredParameters.add(new SqlParameter("source_table", Types.VARCHAR));
        jdbcTemplate.call(csc, declaredParameters);
        */
        jdbcTemplate.update("call stage2.p_merge(?, ?)", tableName, tableName);
        return RepeatStatus.FINISHED;
    }

}
