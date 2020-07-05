FROM openjdk:8u212-jre-alpine
LABEL MAINTAINER="Blutterfly"

RUN apk add --update curl && \
    rm -rf /var/cache/apk/*

ADD ./build/libs/grey-door-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx1024m", "-jar", "/app/grey-door-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 9003
