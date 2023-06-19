FROM openjdk:20-jdk
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} token-service.jar
ENTRYPOINT ["java","-jar","/token-service.jar"]