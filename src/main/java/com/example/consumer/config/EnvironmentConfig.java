package com.example.consumer.config;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentConfig {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Imprimir o valor da variável DB_DRIVER
        String dbDriver = dotenv.get("DB_DRIVER");
        System.out.println("Driver do Banco de Dados: " + dbDriver);

        // Outros exemplos para verificar as demais variáveis
        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");

        System.out.println("URL do Banco de Dados: " + dbUrl);
        System.out.println("Usuário do Banco de Dados: " + dbUsername);
        System.out.println("Senha do Banco de Dados: " + dbPassword);
    }
}