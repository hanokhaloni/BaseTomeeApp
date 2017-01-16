cd %1
cd client_build
cd client_installation
cd %2
cd build
echo "runApkGradle"
set JAVA_OPTS= -agentlib:jdwp=transport=dt_socket,address=8788,server=y,suspend=n
CMD /C gradlew.bat assembleRelease
