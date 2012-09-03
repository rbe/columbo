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

package eu.artofcoding.grownloader;

import eu.artofcoding.grownloader.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JdbcHelper {

    @Slf4j
    private static Logger logger;

    public static void findColumns(DataSource dataSource, String tableName, String columnPattern) throws SQLException {
        // Analyze table
        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet columnsResultSet = databaseMetaData.getColumns(null, null, tableName, columnPattern);
        while (columnsResultSet.next()) {
            System.out.println(columnsResultSet.getString("COLUMN_NAME") + " " + columnsResultSet.getString("TYPE_NAME"));
        }
    }

}
