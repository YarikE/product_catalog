FROM openjdk:17-alpine

WORKDIR /app

COPY . /app/

RUN ./mvnw package -DskipTests

ENTRYPOINT ["java", "-jar", "./target/run-backend.jar"]

# CMD while true; do sleep 1000; done