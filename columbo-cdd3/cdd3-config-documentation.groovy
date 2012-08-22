/*
 * Odisee Sync
 *
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */

odisync {
    TEST {
        timeout = 60 * 60 // timeout between synchronisations, 1 hour
        catchup_timeout = 5 // timeout between synchronisations when catching up with the past
        connection {
            source {
                type = 'MySQL'
                driver = 'com.mysql.jdbc.Driver'
                host = 'localhost'
                port = 3306
                user = 'root'
                pwd = ''
                database = 'corma1'
            }
            destination {
                type = 'MySQL'
                driver = 'com.mysql.jdbc.Driver'
                host = 'localhost'
                port = 3306
                user = 'root'
                pwd = ''
                database = 'corma2'
            }
        }
        table {
            table1 {
                source_schema = 'corma1'
                destination_schema = 'corma2'
                columns {
                    ID = [type: 'INT']
                    CUSTOMER = [type: 'VARCHAR(22)']
                }
                where {
                    column = 'bla'
                    mode = 'since_last_sync'
                }
            }
        }
    }
}
