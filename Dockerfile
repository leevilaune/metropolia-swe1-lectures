FROM maven:3.9.12-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=builder /app/target/designpatterns-1.0-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]