package com.varfolomeev.movierating.controller;

import com.amazonaws.util.IOUtils;
import com.varfolomeev.movierating.entity.File;
import com.varfolomeev.movierating.service.FileService;
import com.varfolomeev.movierating.service.MovieService;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/file")
public class FileController {

    private final S3StorageService s3StorageService;
    private final FileService fileService;
    private final MovieService movieService;

    @PostMapping("/upload/{movieId}")
    public String uploadFile(@RequestBody MultipartFile file, @PathVariable Long movieId) throws IOException {
        if (isNull(file) || file.isEmpty()){
            throw new IOException("File is empty");
        }
        var guid = generateFileGUID();
        s3StorageService.putObject(guid, file);
        var existedMovie = movieService.findMovieById(movieId).orElseThrow();
        existedMovie.setMoviePosterKey(guid);
        fileService.saveFile(File.builder()
                .fileGUID(guid)
                .contentType(file.getContentType())
                .name(file.getOriginalFilename())
                .movieId(movieId)
                .build());
        return guid;
    }

//    @GetMapping("/download/{id}")
//    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable Long movieId){
//        var key = movieService.findMovieById(movieId).orElseThrow();
//        var s3File = s3StorageService.getObject(key.getMoviePosterKey());
//        return ResponseEntity.ok()
//                .headers((header) -> {
//                    header.setContentLength(s3File.getObjectMetadata().getContentLength());
//                    header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                })
//                .body(new InputStreamResource(s3File.getObjectContent()));
//    }

    @GetMapping("/download/{movieId}")
    public byte[] downloadFileBytes(@PathVariable Long movieId){
        var key = movieService.findMovieById(movieId)
                .orElseThrow()
                .getMoviePosterKey();
        try {
            var s3File = s3StorageService.getObject(key);
            return IOUtils.toByteArray(s3File.getObjectContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
