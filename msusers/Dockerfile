# Dockerfile para a aplicação msusers
FROM openjdk:17

WORKDIR /app

COPY target/msusers-0.0.1-SNAPSHOT.jar /app/msusers.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/msusers.jar"]

