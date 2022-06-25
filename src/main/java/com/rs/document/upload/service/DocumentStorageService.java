package com.rs.document.upload.service;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rs.document.upload.model.DocumentDetails;
import com.rs.document.upload.repository.DocumentServiceRepository;

@Service
public class DocumentStorageService {

  @Autowired
  private DocumentServiceRepository documentServiceRepository;

  public DocumentDetails store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    DocumentDetails DocumentDetails = new DocumentDetails(fileName, file.getContentType(), "Dummy User", fileName + " added for testing.", new Date(System.currentTimeMillis()),file.getBytes());

    return documentServiceRepository.save(DocumentDetails);
  }

  public DocumentDetails getFile(String id) {
    return documentServiceRepository.findById(id).get();
  }
  
  public Stream<DocumentDetails> getAllFiles() {
    return documentServiceRepository.findAll().stream();
  }
}
