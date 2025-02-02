FROM eclipse-temurin:23.0.1_11-jre-alpine

# Establece un volumen temporal para archivos temporales
# VOLUME /tmp

# Define la zona horaria
ENV TZ="Europe/Madrid"

# Copia el JAR de la aplicación
COPY target/meal-log-app.jar app.jar

# Ejecuta la aplicación con una mejor gestión de entropía
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
