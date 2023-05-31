package com.monolith.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FileEntity {

  byte[] fileEntity;

}
