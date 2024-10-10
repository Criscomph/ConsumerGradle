package com.example.consumer.testController;

import com.example.consumer.controller.PacienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveListarTodosOsPacientes() throws Exception {
        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk());
    }

    @Test
    public void deveRetornarPacientePorId() throws Exception {
        mockMvc.perform(get("/pacientes/1"))
                .andExpect(status().isOk());
    }
}
