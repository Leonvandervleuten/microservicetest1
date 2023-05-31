package com.monolith.demo.service;

import com.monolith.demo.domain.FileEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

  public List<FileEntity> getFile() throws IOException {
    return makeMultipleFileObjectAndReturn();
  }

  private List<FileEntity> makeMultipleFileObjectAndReturn() throws IOException {

    List<FileEntity> fileList = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      FileEntity fe = new FileEntity();
      fe.setFileEntity(readFile().getFileEntity());
      fileList.add(fe);
    }
    return fileList;
  }

  private FileEntity readFile() throws IOException {
    FileEntity fileEntity = new FileEntity();
    fileEntity.setFileEntity(Files.readAllBytes(Paths.get("src/main/resources/util/Free_Test_Data_10.5MB_PDF.pdf")));
    return fileEntity;
  }

}
