package com.jhops10.projeto_clinica.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    public String uploadFile(MultipartFile arquivo);
}
