package com.example.ilyamoyortovarish.Service;

import com.example.ilyamoyortovarish.Repository.DTO.AddStudentDTO;
import com.example.ilyamoyortovarish.Repository.DTO.StudentDTO;
import com.example.ilyamoyortovarish.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

      void addStudent(StudentDTO studentDTO);
      void deleteStudent(Student student);
      List<Student>getAllStudents();

      List<Student> addStudentInGroup(AddStudentDTO addStudentDTO);

      void saveAllStudents(List<Student> students);



}
