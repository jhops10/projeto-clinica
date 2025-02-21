package com.jhops10.projeto_clinica;

import com.jhops10.projeto_clinica.model.FichaPaciente;
import com.jhops10.projeto_clinica.service.fichaPaciente.IFichaPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class FichaPacienteTests {

    @Autowired
    IFichaPacienteService pacienteService;


    @Test
    public void shouldCreateFichaPaciente() {
        FichaPaciente f = new FichaPaciente();
        f.setNome("João Paulo");
        FichaPaciente res = pacienteService.cadastrar(f);
        assertTrue(res != null && res.getUuid() != null && res.getAtivo() == 1);
    }

    @Test
    public void shouldDeleteFichaPaciente() {
        assertTrue(pacienteService.excluir(1));
    }

    @Test
    public void shouldNotDeleteFichaPaciente() {
        assertFalse(pacienteService.excluir(123158123));
    }

    @Test
    public void shouldReturnSeveralFicha() {
        List<FichaPaciente> fichas = pacienteService.buscarPorNome("a");
        assertFalse(fichas.isEmpty());
    }

    @Test
    public void shouldNotFoundFicha() {
        List<FichaPaciente> fichas = pacienteService.buscarPorNome("zzzz");
        assertTrue(fichas.isEmpty());
    }
}
