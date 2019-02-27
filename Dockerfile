# Set the locale
RUN sed -i -e 's/# en_US.UTF-8 UTF-8/en_US.UTF-8 UTF-8/' /etc/locale.gen && \
    locale-gen
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

FROM openjdk:8
ADD target/dockertest.jar dockertest.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "dockertest.jar"]