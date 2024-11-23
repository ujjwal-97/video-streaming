# Stage 1: Build the application
FROM gradle:8.5-jdk21 AS builder
WORKDIR /app

# Copy source code and build file
COPY . .

# Generate Gradle wrapper
RUN gradle wrapper --gradle-version 8.5 \
    && chmod +x gradlew

# Run the build
RUN ./gradlew build -Dquarkus.package.type=uber-jar

# Stage 2: Create the runtime image
FROM amazoncorretto:21-alpine
WORKDIR /app

# Copy the built artifact from builder stage
COPY --from=builder /app/build/quarkus-app/quarkus-run.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]