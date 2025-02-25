package com.jhops10.projeto_clinica.service.upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class UploadServiceImpl implements IUploadService {

    @Override
    public String uploadFile(MultipartFile arquivo) {
        try {
            System.out.println("DEBUG - Realizando upload do arquivo " + arquivo.getOriginalFilename());
            String pastaDestino = "E:\\DEVELOPMENT\\Java\\Projetos\\ISIFLIX\\upload_arquivos_clinica";
            String extension = arquivo.getOriginalFilename().substring(arquivo.getOriginalFilename().lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + extension;

            Path path = Paths.get(pastaDestino + File.separator + newFileName);
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
