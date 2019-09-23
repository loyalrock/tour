cd /opt/projects/tour
git pull
mvn clean package  -Dmaven.test.skip=true
ps -ef|grep 'java' |grep -v grep|cut -c 9-15|xargs kill -9 >/dev/null 2>&1
nohup java -jar target/tour-0.0.1-SNAPSHOT.jar  &
tail -f /opt/projects/tour/log/info.tour.log
