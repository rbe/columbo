package eu.artofcoding.grownloader2.test;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table1RowMapper implements RowMapper<Table1> {

    @Override
    public Table1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Table1 entity = new Table1();
        entity.setId(rs.getInt("id"));
        entity.setCustomer(rs.getString("customer"));
        entity.setBla(rs.getString("bla"));
        entity.setBlub(rs.getString("blub"));
        return entity;
    }

}
