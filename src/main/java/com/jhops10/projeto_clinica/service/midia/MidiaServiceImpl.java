package com.jhops10.projeto_clinica.service.midia;

import com.jhops10.projeto_clinica.model.Midia;
import com.jhops10.projeto_clinica.repository.MidiaRepository;
import org.springframework.stereotype.Service;

@Service
public class MidiaServiceImpl implements IMidiaService {

    private final MidiaRepository midiaRepository;

    public MidiaServiceImpl(MidiaRepository midiaRepository) {
        this.midiaRepository = midiaRepository;
    }

    @Override
    public Midia cadastrarNova(Midia midia) {
        return midiaRepository.save(midia);
    }

    @Override
    public Midia alterarDados(Midia midia) {
        return midiaRepository.save(midia);
    }

    @Override
    public boolean excluir(Integer id) {
        if (midiaRepository.existsById(id)) {
            midiaRepository.deleteById(id);
        }
        return false;
    }

    @Override
    public Midia recuperarPeloId(Integer id) {
        return midiaRepository.findById(id).orElse(null);
    }
}
