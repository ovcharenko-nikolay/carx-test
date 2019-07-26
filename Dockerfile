FROM openjdk:8-jdk-alpine
ADD /target/carx-test.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]