FROM maven:3.8.4-openjdk-11-slim AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package -DskipTests

FROM openjdk:11

COPY --from=MAVEN_BUILD /target/weather-0.0.1-SNAPSHOT.jar /weather.jar

CMD ["java","-jar","/weather.jar"]