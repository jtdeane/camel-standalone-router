FROM openjdk:8u141-jdk-slim
MAINTAINER jeremydeane.net
EXPOSE 9005
RUN mkdir /app/
COPY target/camel-standalone-router-1.0.2.jar /app/
ENTRYPOINT exec java $JAVA_OPTS -Dactivemq.hostname='magic-broker' -jar /app/camel-standalone-router-1.0.2.jar