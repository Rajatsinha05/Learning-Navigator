# Use a base image with Java runtime
FROM eclipse-temurin:17-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY ./build/libs/Navigator-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8090

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
