FROM openjdk:17-alpine

EXPOSE 8080:9091

COPY OpenServices /app
WORKDIR /app

RUN ./gradlew build

CMD ["java", "-jar", "/app/build/libs/core.jar"]