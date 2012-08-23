package eu.artofcoding.grownloader2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class StateHelper {

    private static final Logger logger = LoggerFactory.getLogger(StateHelper.class.getName());

    private String tableName;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private final String stateQuery = "SELECT last_download, download_hours FROM cddstate WHERE table_name = ?";

    private StateEntity stateEntity;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Get state of downloads for this table.
     * As we calculate times (for use with BETWEEN ... AND ... queries), this method should be only called once.
     *
     * @return
     */
    public StateEntity getState() {
        // Query 'since last download'
        Map<String, Object> map = jdbcTemplate.queryForMap(stateQuery, tableName);
        Timestamp last_download = (Timestamp) map.get("last_download");
        Integer download_hours = (Integer) map.get("download_hours");
        // Create StateEntity
        stateEntity = new StateEntity();
        // Calculate last_download + download_hours and save this values in StateEntity
        Calendar dateFrom = Calendar.getInstance();
        dateFrom.setTimeInMillis(last_download.getTime());
        stateEntity.setDateFrom(dateFrom);
        Calendar dateTo = (Calendar) dateFrom.clone();
        dateTo.add(Calendar.HOUR_OF_DAY, download_hours);
        stateEntity.setDateTo(dateTo);
        //
        return stateEntity;
    }

    /**
     * Write new state of downlods of table in state table.
     *
     * @return
     */
    public StateEntity nextState() {
        logger.info("Recording last_download date: " + stateEntity.getDateTo().getTime());
        jdbcTemplate.update("UPDATE cddstate SET last_download = ? WHERE table_name = ?", stateEntity.getDateTo(), tableName);
        return stateEntity;
    }

}
