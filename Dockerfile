FROM openjdk:11
VOLUME /tmp
#COPY target/gazin-api-0.0.1-SNAPSHOT.jar /app.jar
COPY gazin-api-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java","-jar","/app.jar"]