/*
 * Grownloader
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.osgigronwloader

import java.sql.Timestamp
import java.text.SimpleDateFormat

/**
 *
 */
class Gronstants {

    /**
     * ISO date format.
     */
    protected static final SimpleDateFormat isoDate = new SimpleDateFormat("yyyyMMdd")

    /**
     * ISO date format with time.
     */
    protected static final SimpleDateFormat mysqlIsoDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm")

    /**
     * German date format with hour and minute.
     */
    protected static final SimpleDateFormat lastSyncDate = new SimpleDateFormat("dd.MM.yyyy HH:mm")

    /**
     * SQL Server can store dates starting at 01.01.1753 only.
     */
    protected static final Timestamp sqlServerMinimumTimestamp = new Timestamp(-147, 0, 1, 0, 0, 0, 0)

    /**
     * Default fetch size (how many rows to fetch?).
     */
    protected static final int defaultFetchSize = 100

    /**
     * Default row count for commits.
     */
    protected static final int defaultCommitRows = 100
}
