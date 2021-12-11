#FROM java:11
FROM openjdk:11
VOLUME /tmp
#WORKDIR /app
ADD ssmp.jar app.jar
COPY application-pro.yml application.yml
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.location=/application.yml"]
#ENTRYPOINT ["java","-jar","/app.jar"]