package com.varfolomeev.movierating.controller;

import com.varfolomeev.movierating.entity.File;
import com.varfolomeev.movierating.service.FileService;
import com.varfolomeev.movierating.service.S3StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.varfolomeev.movierating.utils.Utils.generateFileGUID;
import static java.util.Objects.isNull;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/file")
public class FileController {

    private final S3StorageService s3StorageService;
    private final FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile file) throws IOException {
        if (isNull(file) || file.isEmpty()){
            throw new IOException("File is empty");
        }
        var guid = generateFileGUID();
        s3StorageService.putObject(guid, file);
        fileService.saveFile(File.builder()
                .fileGUID(guid)
                .contentType(file.getContentType())
                .name(file.getOriginalFilename())
                .build());
        return guid;
    }

    @GetMapping("/download/{key}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String key){
        var s3File = s3StorageService.getObject(key);
        return ResponseEntity.ok()
                .headers((header) -> {
                    header.setContentLength(s3File.getObjectMetadata().getContentLength());
                    header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                })
                .body(new InputStreamResource(s3File.getObjectContent()));
    }
}
