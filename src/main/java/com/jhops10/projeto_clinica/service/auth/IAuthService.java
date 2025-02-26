package com.jhops10.projeto_clinica.service.auth;

import com.jhops10.projeto_clinica.model.Usuario;
import com.jhops10.projeto_clinica.security.ClinicaToken;

public interface IAuthService {

    public Usuario criarUsuario(Usuario usuario);
    public ClinicaToken realizarLogin(Usuario dadosUsuario);
}
