FROM anapsix/alpine-java:8

ADD ./build/libs/fan-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/fan-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082