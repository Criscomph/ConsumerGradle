# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY build/libs/*.jar app.jar

# Copiar o arquivo .env para o contêiner
COPY .env .env

# Expor a porta 8080
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
