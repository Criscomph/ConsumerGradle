# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definir diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY build/libs/*.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
