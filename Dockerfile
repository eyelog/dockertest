# Set the locale
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

FROM openjdk:8
ADD target/dockertest.jar dockertest.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "dockertest.jar"]