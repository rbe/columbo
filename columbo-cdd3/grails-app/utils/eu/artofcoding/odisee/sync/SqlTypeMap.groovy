/*
 * Odisee Sync
 *
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.odisee.sync

/**
 * Created by IntelliJ IDEA.
 * User: rbe
 * Date: 03.02.12
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
class SqlTypeMap {

    /**
     * SQL types mapped to Java types.
     */
    Map<String, Class> sqlToJavaTypeMap = [
            'CHAR': String,
            'VARCHAR': String,
            'VARCHAR2': String,
            'LONGVARCHAR': String,
            'NUMERIC': java.math.BigDecimal,
            'DECIMAL': java.math.BigDecimal,
            'BIT': Boolean,
            'TINYINT': Integer,
            'SMALLINT': Integer,
            'INTEGER': Integer,
            'BIGINT': Long,
            'REAL': Float,
            'FLOAT': Double,
            'DOUBLE': Double,
            'BINARY': byte[],
            'VARBINARY': byte[],
            'LONGVARBINARY': byte[],
            'DATE': java.sql.Date,
            'TIME': java.sql.Time,
            'TIMESTAMP': java.sql.Timestamp
    ]

    /**
     * Oracle SQL types mapped to Microsoft SQL Server types.
     */
    Map<String, String> oracleToMicrosoftTypeMap = [
            'CHAR': 'CHAR',
            'VARCHAR': 'NVARCHAR',
            'VARCHAR2': 'NVARCHAR',
            'LONGVARCHAR': 'NVARCHAR',
            'NUMBER': 'NUMERIC',
            'NUMERIC': 'NUMERIC',
            'DECIMAL': 'DECIMAL',
            'BIT': 'BIT',
            'TINYINT': 'TINYINT',
            'SMALLINT': 'SMALLINT',
            'INTEGER': 'INTEGER',
            'BIGINT': 'NUMERIC',
            'REAL': 'FLOAT',
            'FLOAT': 'FLOAT',
            'DOUBLE': 'NUMERIC',
            'BINARY': 'BINARY',
            'VARBINARY': 'VARBINARY',
            'LONGVARBINARY': 'IMAGE',
            'DATE': 'DATETIME',
            'TIME': 'DATETIME',
            'TIMESTAMP': 'DATETIME2'
    ]

    /**
     *
     * @param t
     * @return
     */
    def lookupOracleToMicrosoftType(col) {
        //ResultSetMetadata rsmd, int colNum
        ////String typeName = rsmd.getColumnTypeName()
        def typeName = col.columnTypeName.toLowerCase()
        def m = oracleToMicrosoftTypeMap.findAll {
            it.key.toLowerCase() == typeName || it.value.toLowerCase() == typeName
        }
        def prec = col.precision
        def scale = col.scale
        def foundType = m.values().toArray().first()
        def ret
        switch (foundType) {
            case 'DATETIME':
                ret = foundType
                break
            case 'NUMERIC':
                ret = "${foundType}"
                if (prec > 0) {
                    ret += "(${prec})"
                }
                break
            default:
                ret = "${foundType}(${prec})"
                break
        }
        //println "lookupOracleToMicrosoftType: ${col.columnName} ${col.columnTypeName} -> ${ret}"
        return ret
    }

}
