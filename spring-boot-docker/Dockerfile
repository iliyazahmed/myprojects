# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Copy the packaged JAR file into the container
COPY target/spring-boot-docker.jar spring-boot-docker.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Run the JAR file when the container launches
CMD ["java", "-jar", "/spring-boot-docker.jar"]
