FROM anapsix/alpine-java:8

ADD ./build/libs/campaign-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/campaign-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081