FROM openjdk:17

#ARG JAR_FILE=target/*.jar
#RUN mkdir -p /usr/src/app
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#WORKDIR /usr/src/app

COPY target/spring-sport-1.0-SNAPSHOT.jar /spring-sport.jar

ENTRYPOINT ["java","-jar","/spring-sport.jar"]