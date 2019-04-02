FROM openjdk:8-jdk-alpine

COPY build/libs/api-frontend-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT exec java -jar /app.jar