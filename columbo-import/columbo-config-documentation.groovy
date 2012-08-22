/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */

//
// Columbo main configuration file.
//

// Grails Camel Context
grails.camel.camelContextId = 'columbo1'
// Columbo
columbo {
    // Base directory for all operations of Columbo
    base = 'var'
    //
    // CSV File Splitter
    //
    splitter {
        // Where to read from/write to/place CSV files?
        directories {
            // Base
            base = "${columbo.base}"
            input = "${base}/input"
            success = "${base}/success"
            error = "${base}/error"
            done = "${base}/done"
        }
        // Primary keys of tables, used to split files
        // Attn: include "" in column name
        primaryKeys = [
            'HP_COUNTRY_DM':     ['"COUNTRY_ID"'],
            'WFM_CASE':          ['"ACCOUNTABILITY_ID"'],
            'CASE_END2END':      ['"CASE_ID"'],
            'WFM_SUBCASE':       ['"SUBCASE_ID"'],
            'SUBCASE_END2END':   ['"SUBCASE_ID"'],
            'HP_OFFER_DM':       ['"OFFER_ID"'],
            'HP_PART_ORDER_DM':  ['"HP_PART_ORDER_ID"'],
            'HP_PARTS_INFO_DM':  ['"PARTS_INFO_ID"'],
            'HP_SV_DLVR_DM':     ['"HP_SV_DLVR_ID"'],
            'ONSITE_LOG_DM':     ['"ONSITE_LOG_ID"'],
            'EMPLOYEE_TABLE_DM': ['"EMPLOYEE_TABLE_ID"'],
            'NOTES_LOG':         ['"CASE_ID"', '"NOTES_LOG_ID"'],
            'PHONE_LOG':         ['"CASE_ID"', '"PHONE_LOG_ID"']
        ]
        // Options for Apache Camel
        camel {
            // See http://camel.apache.org/file2.html
            readLock = 'changed'
            readLockTimeout = 100000 // 10 seconds
        }
    }
    //
    // Database, Data Warehouse
    //
    database {
        // Microsoft SQL Server
        type = 'sqlserver'
        driverClassName = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
        hostname = 'sqlserver'
        port = 1433
        database = 'GCSS'
        username = 'gcss'
        password = ''
        // Stage 1
        stage1 {
            // Map names, path in file name to... e.g. used with Windows
            nameMap = [
                '/Users/rbe': 'G:',
            ]
            // SQL Server format files
            formatFilePath = 'E:/Columbo/GCSS/fmt1'
        }
        // Options for Apache Camel
        camel {
            // See http://camel.apache.org/file2.html
            readLock = 'changed'
            readLockTimeout = 100000 // 10 seconds
        }
    }
    //
    // Email, notifications
    //
    mail {
        hostname = 'mail.example.com'
        port = 465
        username = 'sender@example.com'
        password = ''
        from = 'sender@example.com'
        to =  'recipient@example.com' //'jk@corma.de,ralf@art-of-coding.eu'
    }
}
