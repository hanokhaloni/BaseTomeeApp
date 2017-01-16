JAVA_OPTS="-Dejb.jndi.name.scouter.module=scouter\
 -Xms512m -Xmx2048m\
 -Duser.language=EN -Duser.region=US\
 -XX:MaxPermSize=1024m\
 -Dproperties.mode=EXTERNAL\
 -Dfile.encoding=utf-8\
 -Dconf.dir=$CATALINA_HOME/conf/scouter\
 -Dtemp.dir=$CATALINA_HOME%/temp
 -javaagent:$CATALINA_HOME/lib/openejb-javaagent.jar"
echo JAVA_OPTS=$JAVA_OPTS
