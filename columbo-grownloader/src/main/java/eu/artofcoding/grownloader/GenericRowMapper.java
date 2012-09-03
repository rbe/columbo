/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 1:43 PM
 */

package eu.artofcoding.grownloader;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.springframework.util.ReflectionUtils.FieldCallback;

public class GenericRowMapper<T extends Serializable> implements RowMapper<T> {

    private Class<T> entityClass;

    public GenericRowMapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T mapRow(final ResultSet rs, int rowNum) throws SQLException {
        final T entity;
        try {
            entity = entityClass.newInstance();
            ReflectionUtils.doWithFields(entityClass, new FieldCallback() {
                @Override
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        final String fieldName = field.getName();
                        ReflectionUtils.makeAccessible(field);
                        try {
                            field.set(entity, rs.getObject(fieldName));
                        } catch (SQLException e) {
                            // Field does not exist, try with underscore
                            final String name_w_underscore = StringHelper.mapCamelCaseToUnderscore(fieldName);
                            try {
                                field.set(entity, rs.getObject(name_w_underscore));
                            } catch (SQLException sqle) {
                                //throw new IllegalAccessException("Could not access field " + fieldName + ": " + e.getMessage());
                                // ignore
                            }
                        }
                    }
                }
            });
            return entity;
        } catch (InstantiationException e) {
            throw new SQLException("Could not create instance of entity bean", e);
        } catch (IllegalAccessException e) {
            throw new SQLException("Could not create instance of entity bean", e);
        }
    }

}
