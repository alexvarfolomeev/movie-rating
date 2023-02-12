package com.varfolomeev.movierating.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.varfolomeev.movierating.config.S3Properties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@AllArgsConstructor
public class S3StorageService {
    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    public PutObjectResult putObject(String key, MultipartFile file){
        return amazonS3Client.putObject(s3Properties.getBucketName(), key, (File) file);
    }

    public S3Object getObject(String key){
        return getObject(s3Properties.getBucketName(), key);
    }

    public S3Object getObject(String bucketName, String key){
        try {
            return amazonS3Client.getObject(new GetObjectRequest(bucketName, key));
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
