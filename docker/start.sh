#!/bin/bash
configUrl=$1/api/download?application=$2\&tag=$3
echo $configUrl
wget -O app.yml $configUrl
echo "*****************************************************配置文件开始*************************************************************************************"
cat app.yml
echo "*****************************************************配置文件结束*************************************************************************************"
java  -jar -Xms2048m -Xmx2048m service-data-statistics.jar --spring.config.location=./app.yml  --spring.config.name=app
