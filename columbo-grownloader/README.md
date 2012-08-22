# Synopsis

Download data from a 'source' database and insert/update/merge it into a 'destination' database.

# Start

Felix:
java -Dgrownloader-config=/path/to/etc/grownloader-config.groovy -jar bin/felix.jar

Standalone:
java -Dgrownloader-config=/path/to/etc/grownloader-config.groovy -cp ... eu.artofcoding.grownloader.Grownloader

# Configuration

## OSGi Container

install http://www.knopflerfish.org/repo/jars/util/util-2.0.1.jar
install http://www.knopflerfish.org/repo/jars/desktop/desktop_all-3.1.6.jar

start org.knopflerfish.bundle.desktop

# Development

## JDBC Drivers

Due to licensing restrictions, please download Oracle and SQL Server JDBC drivers yourself and add them to your local
Maven repository.

### Oracle

http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html

mvn install:install-file \
     -Dpackaging=jar -DgeneratePom=true \
     -DgroupId=com.oracle -DartifactId=ojdbc6 \
     -Dversion=11.2.0.3.0 -Dfile=ojdbc6.jar

### SQL Server

http://www.microsoft.com/en-us/download/details.aspx?displaylang=en&id=11774

mvn install:install-file \
     -Dpackaging=jar -DgeneratePom=true \
     -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 \
     -Dversion=4.0 -Dfile=sqljdbc4.jar
