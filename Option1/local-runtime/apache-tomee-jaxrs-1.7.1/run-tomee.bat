@echo off

set CATALINA_HOME=%cd%
set CATALINA_CONF=%CATALINA_HOME%\conf
set JRE_HOME=%JAVA_HOME%\jre

set JAVA_OPTS=%JAVA_OPTS% -Xms512m -Xmx2048m
set JAVA_OPTS=%JAVA_OPTS% -XX:MaxPermSize=1024m
set JAVA_OPTS=%JAVA_OPTS% -Duser.language=EN -Duser.region=US
set JAVA_OPTS=%JAVA_OPTS% -Dproperties.mode=EXTERNAL
set JAVA_OPTS=%JAVA_OPTS% -Dconf.dir="%CATALINA_CONF%\scouter"
set JAVA_OPTS=%JAVA_OPTS% -Dtemp.dir="%CATALINA_HOME%\temp"
set JAVA_OPTS=%JAVA_OPTS% -Dfile.encoding=utf-8
set JAVA_OPTS=%JAVA_OPTS% -Dejb.jndi.name.scouter.module=scouter
set JAVA_OPTS=%JAVA_OPTS% -Djava.security.auth.login.config="%CATALINA_CONF%\login.config"
set JAVA_OPTS=%JAVA_OPTS% -javaagent:%CATALINA_HOME%\lib\openejb-javaagent.jar

rem ----for debug purposes----
set JAVA_OPTS=%JAVA_OPTS% -agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=n

cd %CATALINA_HOME%\bin
call startup.bat