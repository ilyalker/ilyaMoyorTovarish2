package com.example.ilyamoyortovarish.Service;

import com.example.ilyamoyortovarish.Repository.DTO.AddStudentDTO;
import com.example.ilyamoyortovarish.Repository.DTO.StudentDTO;
import com.example.ilyamoyortovarish.Entity.Group;
import com.example.ilyamoyortovarish.Entity.Student;
import com.example.ilyamoyortovarish.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Autowired
    private GroupServiceImpl groupService;



    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setDate(studentDTO.getDate());
        repository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        repository.deleteById(student.getStudentId());
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students;
        students = repository.findAll();
        return students;
    }

    @Override
    public List<Student> addStudentInGroup(AddStudentDTO addStudentDTO) {
        Student student =new Student();
        Group group = new Group();
        group.setGroupNumber(addStudentDTO.getGroupNumber()); //тут номер группы лежит
        student.setName(addStudentDTO.getName()); // тут имя студента


        List<Student> allStudents = getAllStudents(); // создаем список всех студентов
        List<Group> allGroups = groupService.getAllGroups();// создаем список всех групп


        for (  Group groupIn : allGroups ) {
            if(groupIn.getGroupNumber().equals(group.getGroupNumber())){

               group = groupIn;

            }
        }


        for (  Student studentIn : allStudents ) {
            if(studentIn.getName().equals(student.getName())){

                studentIn.setGroup(group);
                student = studentIn;
                allStudents.remove(studentIn);
                allStudents.add(student);

            }
        }
        return allStudents;
    }

    @Override
    public void saveAllStudents(List<Student> students) {
        repository.saveAll(students);
    }


}

