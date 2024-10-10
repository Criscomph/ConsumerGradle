package com.example.consumer.service;

import com.example.consumer.model.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private PacienteService pacienteService;

    @KafkaListener(topics = "nome_do_topico", groupId = "consumer-group")
    public void listen(String message) {
        System.out.println("Mensagem recebida: " + message);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Paciente paciente = objectMapper.readValue(message, Paciente.class);
            pacienteService.salvarPaciente(paciente);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao processar a mensagem Kafka");
        }
    }
}