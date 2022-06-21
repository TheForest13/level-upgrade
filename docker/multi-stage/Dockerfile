FROM openjdk:11 AS BUILD_STAGE

WORKDIR /home/app
COPY . .

RUN chmod 755 ./gradlew
RUN ./gradlew clean build

FROM openjdk:11-jre-slim

WORKDIR /app
COPY --from=BUILD_STAGE /home/app/build/libs/docker-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]