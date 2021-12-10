#FROM java:11
FROM openjdk:11
VOLUME /tmp
ADD ssm.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
