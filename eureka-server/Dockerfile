FROM openjdk:20-jdk

# Copiar el archivo .jar a la imagen
COPY target/eureka-server-0.0.1-SNAPSHOT.jar /usr/app/eureka-server-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que tu servicio estará escuchando
EXPOSE 8761

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/usr/app/eureka-server-0.0.1-SNAPSHOT.jar"]

