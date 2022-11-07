package com.example.ilyamoyortovarish.Controller;

import com.example.ilyamoyortovarish.Repository.DTO.AddStudentDTO;
import com.example.ilyamoyortovarish.Repository.DTO.GroupDTO;

import com.example.ilyamoyortovarish.Repository.DTO.StudentDTO;
import com.example.ilyamoyortovarish.Entity.Group;
import com.example.ilyamoyortovarish.Entity.Student;
import com.example.ilyamoyortovarish.Service.GroupServiceImpl;
import com.example.ilyamoyortovarish.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController // данная аннтация включает в себя обычный контроллер и респонс бади чтобы можно было возвращать json

@RequestMapping("/") //задаем ему путь (адрес юрл)
public class Controller {


    @Autowired
    private GroupServiceImpl groupService;
    @Autowired
    private StudentServiceImpl studentService;




    @PostMapping ("/addGroup")// данный метод добавляет группу. ставим пост чтобы скрыть данные из юрл
    public void addGroup(@RequestBody GroupDTO groupDTO){ // считывание объекта из тела запроса реквест боди

        groupService.addGroup(groupDTO); // вызываем метод из сервиса который создает группу и добавляет в нее номер

    }

    @GetMapping ( "/allGroups")
    public List<Group> getAllGroup(){
       return groupService.getAllGroups();
    }
    @PostMapping("/deleteGroup")
    public void deleteGroup(@RequestBody GroupDTO groupDTO){
        groupService.deleteGroup(groupDTO);
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody StudentDTO studentDTO){
       studentService.addStudent(studentDTO);
    }

    @PostMapping("/deleteStudent")
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
    }
    @GetMapping ( "/allStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/addStudentInGroup")
    public void addStudentInGroup(@RequestBody AddStudentDTO addStudentDTO){
       List<Student> students = studentService.addStudentInGroup(addStudentDTO);
       studentService.saveAllStudents(students);


    }

}
