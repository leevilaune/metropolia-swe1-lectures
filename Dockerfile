# Use an official OpenJDK 17 slim image
FROM eclipse-temurin:17-jdk-focal
# Set a working directory inside the container
WORKDIR /app

# Copy the jar built by Maven into the container
COPY target/designpatterns-1.0-SNAPSHOT.jar app.jar

# Expose a port if needed (optional)
# EXPOSE 8080

# Default command to run your app
CMD ["java", "-jar", "app.jar"]