package com.jhops10.projeto_clinica.service.fichaPaciente;

import com.jhops10.projeto_clinica.model.FichaPaciente;

import java.util.List;

public interface IFichaPacienteService {

    public FichaPaciente cadastrar(FichaPaciente fichaPaciente);
    public FichaPaciente alterar(FichaPaciente fichaPaciente);
    public List<FichaPaciente> buscarPorNome(String nome);
    public FichaPaciente recuperarPeloId(Integer id);
    public boolean excluir (Integer id);
}
