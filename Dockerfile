## Use an official OpenJDK runtime as a parent image
#FROM eclipse-temurin:21-jdk-alpine
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the application's jar file to the container
#COPY target/crud-0.0.1-SNAPSHOT.jar app.jar
#
## Expose the port your Spring Boot app runs on
#EXPOSE 8082
#
## Run the jar file
#ENTRYPOINT ["java","-jar","/app/app.jar"]

# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/crud-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]

