package com.jhops10.projeto_clinica.controller;

import com.jhops10.projeto_clinica.model.FichaPaciente;
import com.jhops10.projeto_clinica.service.fichaPaciente.IFichaPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FichaPacienteController {

    private final IFichaPacienteService fichaPacienteService;

    public FichaPacienteController(IFichaPacienteService fichaPacienteService) {
        this.fichaPacienteService = fichaPacienteService;
    }

    @GetMapping("/fichas/busca")
    public ResponseEntity<List<FichaPaciente>> buscarPorNome(@RequestParam("nome") String nome) {
        List<FichaPaciente> lista = fichaPacienteService.buscarPorNome(nome);
        if (lista.size() > 0) {
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> buscarPeloId(@PathVariable Integer id) {
        FichaPaciente res = fichaPacienteService.recuperarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/fichas")
    public ResponseEntity<FichaPaciente> cadastrarNova(@RequestBody FichaPaciente nova) {
        FichaPaciente res = fichaPacienteService.cadastrar(nova);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> alterarFicha(@RequestBody FichaPaciente ficha, @PathVariable Integer id) {
        if (ficha.getIdPaciente() == null) {
            ficha.setIdPaciente(id);
        }
        FichaPaciente res = fichaPacienteService.alterar(ficha);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> deletarPorId(@PathVariable Integer id) {
        FichaPaciente res = fichaPacienteService.recuperarPeloId(id);
        if (res != null) {
            fichaPacienteService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
