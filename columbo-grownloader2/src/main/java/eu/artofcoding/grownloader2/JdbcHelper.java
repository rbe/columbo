package eu.artofcoding.grownloader2;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {

    public static void findColumns(DataSource dataSource, String tableName, String columnPattern) throws SQLException {
        // Analyze table
        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet columnsResultSet = databaseMetaData.getColumns(null, null, tableName, columnPattern);
        while (columnsResultSet.next()) {
            System.out.println(columnsResultSet.getString("COLUMN_NAME") + " " + columnsResultSet.getString("TYPE_NAME"));
        }
    }

}
