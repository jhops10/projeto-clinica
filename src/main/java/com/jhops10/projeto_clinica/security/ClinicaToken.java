package com.jhops10.projeto_clinica.security;

public class ClinicaToken {

    private String token;

    public ClinicaToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
