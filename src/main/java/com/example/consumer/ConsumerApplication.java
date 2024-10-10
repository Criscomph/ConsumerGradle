package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {
	public static void main(String[] args) {
		// Carrega o arquivo .env
		Dotenv dotenv = Dotenv.load();

		// Verifica se as variáveis estão sendo lidas corretamente
		System.out.println("DB Driver: " + dotenv.get("DB_DRIVER"));

		// Inicia a aplicação Spring Boot
		SpringApplication.run(ConsumerApplication.class, args);
	}
}