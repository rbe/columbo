/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 1:45 PM
 */

package eu.artofcoding.grownloader2.test;

import eu.artofcoding.grownloader2.GenericRowMapper;

public class Table2RowMapper extends GenericRowMapper<Table2> /*implements RowMapper<Table2>*/ {

    public Table2RowMapper() {
        super(Table2.class);
    }

    /*
    @Override
    public Table2 mapRow(final ResultSet rs, int rowNum) throws SQLException {
        final Table2 entity = new Table2();
        //entity.setId(rs.getInt("id"));
        //entity.setCustomer(rs.getString("customer"));
        //entity.setBla(rs.getString("bla"));
        //entity.setBlub(rs.getString("blub"));
        //entity.setAnotherData(rs.getString("another_data"));
        ReflectionUtils.doWithFields(Table2.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                try {
                    ReflectionUtils.makeAccessible(field);
                    field.set(entity, rs.getObject(field.getName()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return entity;
    }
    */

}
