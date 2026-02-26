# Stage 1: build jar
FROM maven:3.8.8-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: runtime
FROM scratch
WORKDIR /app
COPY --from=builder /app/target/designpatterns-1.0-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]