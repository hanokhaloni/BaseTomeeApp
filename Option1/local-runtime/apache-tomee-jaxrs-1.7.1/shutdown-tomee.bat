@echo off

set CATALINA_HOME=%cd%
set CATALINA_CONF=%CATALINA_HOME%\conf

cd %CATALINA_HOME%\bin
call shutdown.bat
exit