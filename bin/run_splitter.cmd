set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26
set GROOVY_HOME=F:\Columbo\libexec\groovy-1.7.10
set GRAILS_HOME=F:\Columbo\libexec\grails-1.3.7
set PATH=%GRAILS_HOME%\bin;%GROOVY_HOME%\bin;%PATH%
cd columbo_camel
rem Proxy for Grails, see GRAILS-4295
rem grails add-proxy hp "--host=web-proxy.corp.hp.com" "--port=8088"
rem grails set-proxy hp
grails -Dcolumbo.config.location=columbo-config.groovy -Ddisable.auto.recompile=true run-app
cd ..
pause
