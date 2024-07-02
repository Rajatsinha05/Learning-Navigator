# Use a base image with Java
FROM eclipse-temurin:21-jre-jammy

# Set the working directory in the container
WORKDIR /ap
# Copy the jar file from the project directory
COPY ./build/libs/Navigator-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8090
# Command to run the application
CMD ["java", "-jar", "app.jar"]
