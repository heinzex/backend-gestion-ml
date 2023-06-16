FROM openjdk:20-jdk

# Copiar el archivo .jar a la imagen
COPY target/main-server-0.0.1-SNAPSHOT.jar /usr/app/main-server-0.0.1-SNAPSHOT.jar

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/usr/app/main-server-0.0.1-SNAPSHOT.jar"]

