# Dockerfile para a aplicação msnotify
FROM openjdk:21

WORKDIR /app

COPY target/msnotify-0.0.1-SNAPSHOT.jar /app/msnotify.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/msnotify.jar"]
