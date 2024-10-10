# Use a imagem do Gradle para construir o projeto
FROM gradle:7.5.1-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Use uma imagem do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copie o arquivo .jar do build anterior
COPY --from=build /app/build/libs/*.jar consumer.jar

# Exponha a porta da aplicação
EXPOSE 8080

# Comando de entrada para rodar a aplicação
ENTRYPOINT ["java", "-jar", "consumer.jar"]
