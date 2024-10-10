package com.example.consumer.consumer;

import com.example.consumer.model.Paciente;
import com.example.consumer.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "nome_do_topico", groupId = "consumer-group")
public class PacienteConsumer {
    @Autowired
    private PacienteService pacienteService;

    public void consume(String message) {
        // Lógica para transformar a mensagem e salvar no banco
        Paciente paciente = new Paciente(); // Converter mensagem para paciente
        pacienteService.salvarPaciente(paciente);
    }
}
