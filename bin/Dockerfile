FROM copenjdk:11-jre-slim

RUN mkdir /opt/hotel-credentials

WORKDIR /opt/hotel-credentials

COPY ./target/hotel-credentials*.jar hotel-credentials.jar

SHELL ["/bin/bash","-c"]

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT java ${ADDITIONAL_OPTS} -jar hotel-credentials.jar
