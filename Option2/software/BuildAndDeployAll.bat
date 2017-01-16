@echo off
title BUILD ALL
@CHOICE /M "Are you sure you want to overwrite ALL the war files with on TomEE?"
IF ERRORLEVEL 2 GOTO end
IF ERRORLEVEL 1 GOTO dothat
GOTO end
:dothat
CD "..\..\..\.."
set PROJ_TRUNK=%cd%
set TOMEE_HOME=%PROJ_TRUNK%\local-runtime\apache-tomee-jaxrs-1.7.1
set MODULES_HOME=%PROJ_TRUNK%\software\modules
rem set TOMEE_TEMP=%TOMEE_HOME%\temp
echo -----------------
echo Shutdown tomcat...
echo -----------------
cd "%TOMEE_HOME%"
start /wait shutdown-tomee.bat
echo Press any key when server is down...
pause

echo ---------------------
echo Backup old webapps...
echo ---------------------
set TIMESTAMP=%DATE:~10,4%-%DATE:~4,2%-%DATE:~7,2%-%TIME:~0,2%-%TIME:~3,2%-%TIME:~6,2%
echo Backup folder is: "%TEMP%\%TIMESTAMP%"
move "%TOMEE_HOME%\webapps" "%TEMP%\%TIMESTAMP%"
mkdir "%TOMEE_HOME%\webapps"
echo ----------------
echo Backup Complete.
echo -----------------
echo Press any key if no errors found, else hit [CTRL]+[C]
pause
echo --------------------
echo Building with Gradle
echo --------------------
cd "%PROJ_TRUNK%\software\modules\build\gradle\server\"
call gradle -x test
echo --------------
echo Build Complete
echo --------------
echo Press any key if no delete errors found, else hit [CTRL]+[C]
pause
echo ---------------
echo Copy new WAR... (Done by gradle deployment task)
echo ---------------
CD "%TOMEE_HOME%"
echo --------------
echo To run tomee - press any key, to stop not hit [CTRL]+[C]
echo --------------
pause
run-tomee.bat
:end
