FROM copenjdk:11-jre-slim

RUN mkdir /opt/users-credentials

WORKDIR /opt/users-credentials

COPY ./target/users-credentials*.jar users-credentials.jar

SHELL ["/bin/bash","-c"]

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT java ${ADDITIONAL_OPTS} -jar users-credentials.jar
