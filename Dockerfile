FROM java:8-jre
#fabric8/java-centos-openjdk8-jre
ADD target/springboot-jwt-rest-0.0.1.jar springboot-jwt-rest.jar
#COPY docker/start.sh /
#ENV CONFIG_SERVER_ADDRESS=http://config.dev.kkche.cn \
#    APPLICATION_NAME=service-data-statistics \
#    TAG=dev
#CMD sh start.sh $CONFIG_SERVER_ADDRESS $APPLICATION_NAME $TAG
CMD ["java","-jar", "-Xms2048m", "-Xmx2048m","springboot-jwt-rest.jar"]
