package com.jhops10.projeto_clinica.controller;

import com.jhops10.projeto_clinica.model.Midia;
import com.jhops10.projeto_clinica.service.midia.IMidiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MidiaController {

    private final IMidiaService midiaService;

    public MidiaController(IMidiaService midiaService) {
        this.midiaService = midiaService;
    }

    @GetMapping("/midias/{id}")
    public ResponseEntity<Midia> recuperarPeloId(@PathVariable Integer id) {
        Midia m = midiaService.recuperarPeloId(id);
        if (m != null) {
            return ResponseEntity.ok(m);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/midias")
    public ResponseEntity<Midia> adicionarNovaMidia(@RequestBody Midia midia) {
        Midia res = midiaService.cadastrarNova(midia);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/midias/{id}")
    public ResponseEntity<Midia> alterarDados(@RequestBody Midia midia, @PathVariable Integer id) {
        if (midia.getNumSeq() != null) {
            midia.setNumSeq(id);
        }
        Midia res = midiaService.alterarDados(midia);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/midias/{id}")
    public ResponseEntity<?> excluirMidia(@PathVariable Integer id) {
        Midia res = midiaService.recuperarPeloId(id);
        if (res != null) {
            midiaService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
