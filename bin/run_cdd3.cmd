set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26
set GROOVY_HOME=F:\Columbo\libexec\groovy-1.7.10
set GRAILS_HOME=F:\Columbo\libexec\grails-2.0.0
set PATH=%GRAILS_HOME%\bin;%GROOVY_HOME%\bin;%PATH%
cd cdd3
rem Proxy for Grails, see GRAILS-4295
rem grails add-proxy hp "--host=web-proxy.corp.hp.com" "--port=8088"
rem grails set-proxy hp
set GRAILS_OPTS=-server -XX:MaxPermSize=256m -Xms1024m -Xmx1500m -Dcdd3.config.location=cdd3-config.groovy -Ddisable.auto.recompile=true
grails run-app
cd ..
pause
