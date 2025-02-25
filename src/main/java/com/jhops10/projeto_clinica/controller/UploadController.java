package com.jhops10.projeto_clinica.controller;

import com.jhops10.projeto_clinica.dto.PathToFile;
import com.jhops10.projeto_clinica.service.upload.IUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class UploadController {

    private final IUploadService uploadService;

    public UploadController(IUploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("arquivo") MultipartFile arquivo) {
        String fileName = uploadService.uploadFile(arquivo);

        if (fileName != null) {
            return ResponseEntity.status(201).body(new PathToFile(fileName));
        }
        return ResponseEntity.badRequest().build();
    }
}
