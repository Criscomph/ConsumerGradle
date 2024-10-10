package com.example.consumer.service;

import com.example.consumer.model.Paciente;
import com.example.consumer.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método que lista todos os pacientes
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    // Método que salva um paciente
    public void salvarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    // Método para buscar um paciente por ID
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException("Paciente não encontrado com o ID: " + id));
    }
}
