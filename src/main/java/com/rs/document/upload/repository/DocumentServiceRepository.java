package com.rs.document.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.document.upload.model.DocumentDetails;

@Repository
public interface DocumentServiceRepository extends JpaRepository<DocumentDetails, String> {

}
