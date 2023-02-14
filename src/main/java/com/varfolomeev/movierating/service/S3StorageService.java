package com.varfolomeev.movierating.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.varfolomeev.movierating.config.S3Properties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class S3StorageService {
    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    public PutObjectResult putObject(String key, MultipartFile file){
        return putObject(s3Properties.getBucketName(), key, file);
    }

    private PutObjectResult putObject(String bucketName, String key, MultipartFile file){
        try {
            var metaData = new ObjectMetadata();
            metaData.setContentType(file.getContentType());
            metaData.setContentLength(file.getSize());
            return amazonS3Client.putObject(bucketName, key, file.getInputStream(), metaData);
        } catch (AmazonS3Exception | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public S3Object getObject(String key){
        return getObject(s3Properties.getBucketName(), key);
    }

    private S3Object getObject(String bucketName, String key){
        try {
            if (isFileExist(key)){
                return amazonS3Client.getObject(new GetObjectRequest(bucketName, key));
            } else {
                throw new NoSuchElementException(String.format("File with key %s not found.", key));
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    private Boolean isFileExist(String key) {
        return amazonS3Client.doesObjectExist(s3Properties.getBucketName(), key);
    }

}
