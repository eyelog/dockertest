FROM openjdk:8
COPY target/dockertest.jar dockertest.jar
EXPOSE 8096
ENTRYPOINT ["java", "-jar", "dockertest.jar"]