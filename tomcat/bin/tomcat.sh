#!/bin/bash -l

usage() {
	echo "Usage: $PGR_NAME INSTANCE_NAME COMMANDS"
	echo " $PGR_NAME tom_inst1 start"
	echo " $PGR_NAME tom_inst1 stop"
	echo " $PGR_NAME tom_inst1 status"
	echo " $PGR_NAME tom_inst1 restart"
	echo " $PGR_NAME tom_inst1 trace"
	echo " $PGR_NAME tom_inst1 view "
}

start() {
	echo "waiting for shutting down for $1 seconds."
	$CATALINA_HOME/bin/catalina.sh start
}

healthcheck() {
	WAIT_TIME=$1
	echo "trying to check the health of $INSTANCE_NAME for $WAIT_TIME seconds."
	# TODO health check url for 
}

stop() {
	echo "waiting for shutting down for $1 seconds."
	$CATALINA_HOME/bin/catalina.sh stop $1
}

forcestop() {
	echo "kill tomcat process."
	$CATALINA_HOME/bin/catalina.sh stop $1 -force
}

PGR_NAME=$0
INSTANCE_NAME=$1
COMMAND=$2

shift 3

# default tomcat install directory
cd `dirname $0`/..

DEFAULT_CATALINA_HOME=$HOME/apps/tomcat8
INSTANCE_HOME=`pwd`

export CATALINA_BASE=$INSTANCE_HOME/$INSTANCE_NAME
export CATALINA_PID=$CATALINA_BASE/logs/tomcat.pid

if [ -z $CATALINA_HOME ]; then
	echo "CATALINA_HOME is not specified. used default path. ( $DEFAULT_CATALINA_HOME )"
	CATALINA_HOME=$DEFAULT_CATALINA_HOME
fi

if [ ! -d $CATALINA_HOME ]; then
	echo "CATALINA_HOME is not directory."
	exit 1
fi

if [ -z $INSTANCE_HOME ] || [ ! -d $INSTANCE_HOME ]; then
    echo "INSTANCE_HOME should be specified or exist."
    echo "INSTANCE_HOME=$INSTANCE_HOME"
    exit 1
fi 

if [ -z $INSTANCE_NAME ]; then
	echo "INSTANCE_NAME should be specified."
	usage
	exit 1
fi

if [ ! -d $CATALINA_BASE ]; then
	echo "INSTANCE_NAME does not exist."
	exit 1
fi

if [ -z $STOP_WAIT_TIMEOUT ]; then
	STOP_WAIT_TIMEOUT=30
fi

case $COMMAND in 
	start)
		start
		if [ $? -ne 0 ]; then
			exit 1
		fi
		;;
	stop)
		STOP_WAIT_TIMEOUT=$4

		if [ -z $STOP_WAIT_TIMEOUT ]; then
			STOP_WAIT_TIMEOUT=30
		fi
			
		stop $STOP_WAIT_TIMEOUT
		if [ $? -ne 0 ]; then
			exit 1
		fi
		;;
	restart)
		STOP_WAIT_TIMEOUT=$4
		
		if [ -z $STOP_WAIT_TIMEOUT ]; then
			STOP_WAIT_TIMEOUT=30
		fi

		stop $STOP_WAIT_TIMEOUT
		if [ $? -ne 0 ]; then
			exit 1
		fi
		start
		;;
	forcestop)
		forcestop 0
		if [ $? -ne 0 ]; then
			exit 1
		fi
		;;
	*)
		usage
		;;
esac
