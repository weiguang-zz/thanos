#!/bin/sh

APP_NAME=thanos-soulgem
APP_LOGS_DIR=/data/logs

export JAVA_OPTS="-Dspring.profiles.active=@environment@ \
-server -Xms1024M -Xmx1024M -Xmn512M -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m \
-XX:+UseG1GC -XX:+TieredCompilation \
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime \
-XX:GCLogFileSize=100M -Xloggc:$APP_LOGS_DIR/$APP_NAME/gc.log \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$APP_LOGS_DIR/$APP_NAME/oom.hprof
-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
