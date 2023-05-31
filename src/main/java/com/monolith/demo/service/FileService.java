package com.monolith.demo.service;

import com.monolith.demo.domain.FileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FileService {

  RestTemplate restTemplate = new RestTemplate();

  String url = "http://localhost:8082/file";

  public List<FileEntity> getFile() {
    return getFileFromThirdService();
  }

  private List<FileEntity> getFileFromThirdService() {
    ResponseEntity<FileEntity[]> response = restTemplate.getForEntity(url, FileEntity[].class);
    return List.of(response.getBody());
  }

}
