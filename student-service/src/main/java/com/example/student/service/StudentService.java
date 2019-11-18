package com.example.student.service;

import com.example.student.dto.StudentDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private static List<StudentDto> studentDtos = new ArrayList<>();

  static {
    studentDtos.add(new StudentDto(1, "CaoKD"));
    studentDtos.add(new StudentDto(2, "QuanNT"));
  }

  public List<StudentDto> getAll() {

    return studentDtos;
  }

  public StudentDto getById(int id) {

    return studentDtos.stream().filter(studentDto -> studentDto.getId() == id).findFirst().orElseThrow(() -> new ArithmeticException("Not found!!"));
  }

  public StudentDto create(StudentDto studentDto) {

    studentDtos.add(studentDto);
    return studentDto;
  }
}
