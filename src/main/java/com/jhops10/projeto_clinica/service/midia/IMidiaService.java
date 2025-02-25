package com.jhops10.projeto_clinica.service.midia;

import com.jhops10.projeto_clinica.model.Midia;

public interface IMidiaService {

    public Midia cadastrarNova(Midia midia);
    public Midia alterarDados(Midia midia);
    public boolean excluir(Integer id);
    public Midia recuperarPeloId(Integer id);
}
