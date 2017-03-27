#!/bin/bash
SN=$(basename ${0})
action=$1
#---------Declare Variable-------------------
mvn_path="/home/leson/tools/apache-maven-3.3.9"
mvn_bin_path="${mvn_path}/bin"

tomcat_path="/home/leson/tools/apache-tomcat-8.5.8"
webapps_path=${tomcat_path}/webapps
log_path=${tomcat_path}/logs
bin_path=${tomcat_path}/bin

#---------end delcare-------------------------

if [ "$#" -le 0 ];then
	echo "Syntax: $SN <start|run ...> detail please refer to catalina.sh"
	sh ${bin_path}/catalina.sh
	exit 99
else
	echo "Action:[${action}]"
fi

#-----------delare function---------
function mvn_operate()
{
	sh ${mvn_bin_path}/mvn clean package
	#sleep 2
	cp -v $(pwd)/target/jersey.war ${webapps_path}
}

function tomcat_operate()
{
	sh ${bin_path}/catalina.sh stop 
	#sleep 2
	sh ${bin_path}/catalina.sh ${action}
	sleep 5
	tail -f ${log_path}/catalina.out
}

function main()
{
	mvn_operate | tee mvn.log
	tomcat_operate
}

#-------start logic----------------
main

