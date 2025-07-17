FROM maven:3.9.10-eclipse-temurin-21 AS build
WORKDIR /build
COPY src /build/src
COPY pom.xml /build/pom.xml
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
COPY --from=build /build/target/*.jar /opt/app.jar
CMD ["java" , "-jar" , "/opt/app.jar"]