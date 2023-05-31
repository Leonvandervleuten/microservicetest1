package com.monolith.demo.service;

import com.monolith.demo.domain.FileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

  RestTemplate restTemplate = new RestTemplate();

  String url = "http://localhost:8082/file";

  public List<FileEntity> getFile() throws IOException {
    return makeMultipleFileObjectAndReturn();
  }

  private List<FileEntity> makeMultipleFileObjectAndReturn() throws IOException {

    List<FileEntity> fileList;
    fileList = getFileFromThirdService();

    for (int i = 0; i < fileList.size(); i++) {
      FileEntity fe = new FileEntity();
      fe.setFileEntity(getFileFromThirdService().get(i).getFileEntity());
      fileList.add(fe);
    }
    return fileList;
  }

  private List<FileEntity> getFileFromThirdService() {
    ResponseEntity<FileEntity[]> response = restTemplate.getForEntity(url, FileEntity[].class);
    return List.of(response.getBody());
  }

}
