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
 * For every two parameters in prepared statement, set last_download and last_download + download_hours.
 * Used for e.g.: date_field BETWEEN ? AND ? or date_field >= ? and date_field <= ?
 */
public class PairedDateStatementSetter implements PreparedStatementSetter {

    private static final Logger logger = LoggerFactory.getLogger(PairedDateStatementSetter.class.getName());

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
        int pairs = ps.getParameterMetaData().getParameterCount();
        for (int i = 1; i < pairs + 1; i += 2) {
            ps.setDate(i, new java.sql.Date(dateFrom.getTimeInMillis()));
            ps.setDate(i + 1, new java.sql.Date(dateTo.getTimeInMillis()));
        }
        // TODO [null]
        logger.info(String.format("[" + stateHelper.getState().getTableName() + "] Set date to: between %s and %s", dateFrom.getTime(), dateTo.getTime()));
    }

}
