package com.jhops10.projeto_clinica.repository;

import com.jhops10.projeto_clinica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);
}
