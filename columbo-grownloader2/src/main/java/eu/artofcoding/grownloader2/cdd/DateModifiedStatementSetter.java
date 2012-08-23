package eu.artofcoding.grownloader2.cdd;

import eu.artofcoding.grownloader2.StateEntity;
import eu.artofcoding.grownloader2.StateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Read 'last_download' datetime from database and increase it by 'download_hours'.
 */
public class DateModifiedStatementSetter implements PreparedStatementSetter {

    private static final Logger logger = LoggerFactory.getLogger(DateModifiedStatementSetter.class.getName());

    private StateHelper stateHelper;

    public void setStateHelper(StateHelper stateHelper) {
        this.stateHelper = stateHelper;
    }

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        // Get state for this table's downloads
        StateEntity stateEntity = stateHelper.getState();
        Calendar dateFrom = stateEntity.getDateFrom();
        Calendar dateTo = stateEntity.getDateTo();
        // PreparedStatement
        ps.setDate(1, new java.sql.Date(dateFrom.getTimeInMillis()));
        ps.setDate(2, new java.sql.Date(dateTo.getTimeInMillis()));
        logger.info("Set date to: between " + dateFrom.getTime() + " and " + dateTo.getTime());
    }

}
