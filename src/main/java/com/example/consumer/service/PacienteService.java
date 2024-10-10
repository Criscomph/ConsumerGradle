package com.example.consumer.service;

import com.example.consumer.model.Paciente;
import com.example.consumer.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return null;
    }

    public void salvarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
