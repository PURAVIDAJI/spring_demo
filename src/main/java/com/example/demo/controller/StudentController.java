package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> viewAllStudents(){
        List<Student> allStudent = studentService.getAllStudent();
        return allStudent;
    }

    @GetMapping("/{studentId}")
    public Student viewStudentinfo(@PathVariable int studentId){
        //누구랑 바인딩해줄거냐? 밖에서 오는 애랑-> pathvariable 사용함
        return studentService.getStudentInfo(studentId);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        String res =  studentService.removeStudent(studentId);
        return res;
    }

    @PostMapping
    //니가 요청할때 바디에 담아서 보낸 정보있자나?
    public String addStudent(@RequestBody Student student){
        String res = studentService.addStudent(student);
        return res;
    }

    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable int studentId,
                                @RequestBody StudentDto studentDto){
        String res = studentService.updateStudent(studentId, studentDto);
        return res;

    }
}
