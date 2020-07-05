FROM openjdk:8u212-jre-alpine
LABEL MAINTAINER="Blutterfly"

RUN apk add --update curl && \
    rm -rf /var/cache/apk/*

ADD ./build/libs/blue-door-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx1024m", "-jar", "/app/blue-door-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 9002
