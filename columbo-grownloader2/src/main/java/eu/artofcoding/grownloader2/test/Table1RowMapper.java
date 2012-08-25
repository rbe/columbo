/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 1:46 PM
 */

package eu.artofcoding.grownloader2.test;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table1RowMapper implements RowMapper<Table1> {

    @Override
    public Table1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Table1 entity = new Table1();
        entity.setId(rs.getBigDecimal("id"));
        entity.setCustomer(rs.getString("customer"));
        entity.setBla(rs.getTimestamp("bla"));
        entity.setBlub(rs.getTimestamp("blub"));
        entity.setAnother_data(rs.getString("another_data"));
        return entity;
    }

}
