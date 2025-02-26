package com.jhops10.projeto_clinica.controller;

import com.jhops10.projeto_clinica.model.Usuario;
import com.jhops10.projeto_clinica.security.ClinicaToken;
import com.jhops10.projeto_clinica.service.auth.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> adicionarNovo(@RequestBody Usuario usuario) {
        Usuario res = authService.criarUsuario(usuario);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ClinicaToken> efetuarLogin(@RequestBody Usuario dadosLogin) {
        ClinicaToken token = authService.realizarLogin(dadosLogin);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }
}
