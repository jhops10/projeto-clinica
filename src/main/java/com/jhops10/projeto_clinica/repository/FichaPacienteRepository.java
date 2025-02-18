package com.jhops10.projeto_clinica.repository;

import com.jhops10.projeto_clinica.model.FichaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichaPacienteRepository extends JpaRepository<FichaPaciente, Integer> {

    public List<FichaPaciente> findByNomeContaining(String palavraChave);
}
