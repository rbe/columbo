dataSource {
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            driverClassName = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
            url = 'jdbc:sqlserver://192.168.180.109:1433;databaseName=GCSS'
            username = 'gcss'
            password = ''
            dbCreate = 'update'
        }
    }
    test {
        dataSource {
            pooled = true
            driverClassName = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
            url = 'jdbc:sqlserver://192.168.180.109:1433;databaseName=GCSS'
            username = 'gcss'
            password = ''
            dbCreate = 'update'
        }
    }
    production {
        dataSource {
            pooled = true
            driverClassName = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
            url = 'jdbc:sqlserver://192.168.180.109:1433;databaseName=GCSS'
            username = 'gcss'
            password = ''
            dbCreate = 'update'
        }
    }
}
