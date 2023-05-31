package com.monolith.demo.controller;

import com.monolith.demo.domain.FileEntity;
import com.monolith.demo.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class FileController {

  private FileService fileService;

  @GetMapping("file")
  public List<FileEntity> getFile() throws IOException {
    return fileService.getFile();

  }

}
