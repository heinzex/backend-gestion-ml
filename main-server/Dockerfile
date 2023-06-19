FROM openjdk:20-jdk
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} main-server.jar
ENTRYPOINT ["java","-jar","/main-server.jar"]
