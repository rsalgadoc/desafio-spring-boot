#----------------------------------
# Stage 1
#----------------------------------

# Import docker image with maven installed
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

#--------------------------------------
# Stage 2
#--------------------------------------

# Import small size java image
FROM eclipse-temurin:17-jre-jammy AS deployer

# Copy build from stage 1 (builder)
COPY --from=builder /target/*.jar /target/taskmanagement.jar

# Expose application port 
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "/target/taskmanagement.jar"]