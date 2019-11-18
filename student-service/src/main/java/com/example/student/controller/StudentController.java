package com.example.student.controller;

import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/getAll")
  public ResponseEntity<?> getAll() {

    return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
  }
}
