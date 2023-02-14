package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.File;
import com.varfolomeev.movierating.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public File saveFile(File file){
        return fileRepository.save(file);
    }

    public File getFileByGuid(String guid){
        return fileRepository.findFileByFileGUID(guid);
    }

}
