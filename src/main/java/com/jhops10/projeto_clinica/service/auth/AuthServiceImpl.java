package com.jhops10.projeto_clinica.service.auth;

import com.jhops10.projeto_clinica.model.Usuario;
import com.jhops10.projeto_clinica.repository.UsuarioRepository;
import com.jhops10.projeto_clinica.security.ClinicaToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioRepository.save(usuario);
    }

    @Override
    public ClinicaToken realizarLogin(Usuario dadosUsuario) {
        Usuario res = usuarioRepository.findByLogin(dadosUsuario.getLogin());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (res != null) {
            if (encoder.matches(dadosUsuario.getSenha(), res.getSenha())) {
                return new ClinicaToken("*clinica123");
            }
        }
        return null;
    }
}
