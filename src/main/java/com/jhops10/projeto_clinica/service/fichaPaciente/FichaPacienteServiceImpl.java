package com.jhops10.projeto_clinica.service.fichaPaciente;

import com.jhops10.projeto_clinica.model.FichaPaciente;
import com.jhops10.projeto_clinica.repository.FichaPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FichaPacienteServiceImpl implements IFichaPacienteService {

    private final FichaPacienteRepository pacienteRepository;

    public FichaPacienteServiceImpl(FichaPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public FichaPaciente cadastrar(FichaPaciente fichaPaciente) {
        fichaPaciente.setUuid(UUID.randomUUID().toString());
        fichaPaciente.setAtivo(1);
        return pacienteRepository.save(fichaPaciente);
    }

    @Override
    public FichaPaciente alterar(FichaPaciente fichaPaciente) {
        return pacienteRepository.save(fichaPaciente);
    }

    @Override
    public List<FichaPaciente> buscarPorNome(String nome) {
        return pacienteRepository.findByNomeContaining(nome);
    }

    @Override
    public FichaPaciente recuperarPeloId(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean excluir(Integer id) {
        FichaPaciente ficha = recuperarPeloId(id);
        if (ficha != null) {
            ficha.setAtivo(0);
            pacienteRepository.save(ficha);
            return true;
        }
        return false;
    }
}
