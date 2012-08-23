package eu.artofcoding.grownloader2.test;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Table1Creator implements Tasklet {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try {
            jdbcTemplate.execute("SELECT * FROM table1 WHERE 1=0");
        } catch (DataAccessException e) {
            jdbcTemplate.execute("CREATE TABLE table1 (id INT, customer VARCHAR(100), bla DATETIME, blub DATETIME)");
        }
        return RepeatStatus.FINISHED;
    }

}
