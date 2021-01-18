FROM adoptopenjdk/openjdk11:alpine-jre

#FROM adoptopenjdk/openjdk14:ubi

ARG JAR_FILE=springboot-backend/target/springboot-backend-0.0.1-SNAPSHOT.jar

WORKDIR /app

# cp spring-boot-web.jar /app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


