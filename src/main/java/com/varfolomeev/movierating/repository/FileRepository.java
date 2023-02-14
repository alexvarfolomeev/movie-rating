package com.varfolomeev.movierating.repository;

import com.varfolomeev.movierating.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    File findFileByFileGUID(String guid);
}
