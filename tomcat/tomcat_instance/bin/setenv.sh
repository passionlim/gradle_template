#!/bin/bash

# common configuration
INSTANCE_NAME=${CATALINA_BASE##*/}
PHASE=dev

CATALINA_PID="$CATALINA_BASE/logs/tomcat.pid"

CATALINA_OPTS="$CATALINA_OPTS -Dphase=$PHASE -DinstanceName=${INSTANCE_NAME} -DjvmRoute=INSTANCE_NAME"

# custom properties
CATALINA_OPTS="$CATALINA_OPTS \
	-Dorg.apache.tomcat.util.digester.PROPERTY_SOURCE=cj.oshopping.tomcat.EncryptPropertyDecoder \
	-Dorg.apache.tomcat.util.digester.PROPERTY_SOURCE.targetPath=${CATALINA_BASE}/conf/custom-*.properties "

# tomcat instance port
BASE_PORT=8080

HTTP_PORT=$((BASE_PORT+1))
AJP_PORT=$((BASE_PORT+2))
JMX_PORT=$((BASE_PORT+3))

CATALINA_OPTS="$CATALINA_OPTS -Dhttp.port=${HTTP_PORT} -Dajp.port=${AJP_PORT} -Djmx.port=${JMX_PORT}"

JAVA_OPTS="$JAVA_OPTS \
	-Dcom.sun.management.jmxremote=true \
	-Dcom.sun.management.jmxremote.ssl=false \
	-Dcom.sun.management.jmxremote.authenticate=true \
	-Dcom.sun.management.jmxremote.access.file=${CATALINA_BASE}/conf/jmxremote.access \
	-Dcom.sun.management.jmxremote.password.file=${CATALINA_BASE}/conf/jmxremote.password
	"
# jennifer 
JENNIFER_AGENT=""

if [ ! -z $JENNIFER_AGENT ]; then
	# add jennifer configraution
	echo "$JENNIFER_AGENT"
fi

# memory
JAVA_OPTS="$JAVA_OPTS -server -Xms2048m -Xmx2048m "

#echo "CATALINA_OPTS=$CATALINA_OPTS"
#echo "JAVA_OPTS=$JAVA_OPTS"
