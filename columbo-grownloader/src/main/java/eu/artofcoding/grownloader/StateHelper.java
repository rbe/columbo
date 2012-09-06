/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 11:13 AM
 */

package eu.artofcoding.grownloader;

import eu.artofcoding.grownloader.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

@Component
public class StateHelper {

    @Slf4j
    private static Logger logger;

    private String tableName;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private final String stateQuery = "SELECT last_download, download_hours FROM grownstate WHERE table_name = ?";

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
     * @return
     */
    public StateEntity getState() {
        try {
            // Query 'since last download'
            Map<String, Object> map = jdbcTemplate.queryForMap(stateQuery, tableName);
            Timestamp last_download = (Timestamp) map.get("last_download");
            Integer download_hours = (Integer) map.get("download_hours");
            // Create StateEntity
            stateEntity = new StateEntity();
            stateEntity.setTableName(tableName);
            // Calculate last_download + download_hours and save this values in StateEntity
            Calendar dateFrom = Calendar.getInstance();
            dateFrom.setTimeInMillis(last_download.getTime());
            stateEntity.setDateFrom(dateFrom);
            Calendar dateTo = (Calendar) dateFrom.clone();
            dateTo.add(Calendar.HOUR_OF_DAY, download_hours);
            stateEntity.setDateTo(dateTo);
            return stateEntity;
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalStateException("No information found in state table for " + tableName);
        }
    }

    /**
     * Write new state of downlods of table in state table.
     * @return
     */
    public StateEntity nextState() {
        logger.info(String.format("Recording last_download date: %s", stateEntity.getDateTo().getTime()));
        jdbcTemplate.update("UPDATE grownstate SET last_download = ? WHERE table_name = ?", stateEntity.getDateTo(), tableName);
        return stateEntity;
    }

}
