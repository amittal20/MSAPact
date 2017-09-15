#
# Super simple example of a Dockerfile
#
FROM java
VOLUME /tmp
ADD ItemInfo-0.0.1-SNAPSHOT.jar /eureka.jar
EXPOSE 7580
ENTRYPOINT ["java","-jar","/eureka.jar"]