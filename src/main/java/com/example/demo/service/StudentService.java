package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;

import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    @Autowired //제가 만들어질때, 외부에서 이 부품먼저 만들어서 저에게 주입시켜주세요
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentInfo(int studentId){
        return studentRepository.findById(studentId);

    }

    public String removeStudent(int studentId){
        Student removedstudent = studentRepository.removeById(studentId);
        String result ="";
        if(removedstudent != null)
            result="정상적으로 삭제됨";
        else
            result="삭제과정 오류 발생";
        return result;
    }

    public String addStudent(Student student){
        String result="";
        Integer add = studentRepository.add(student);
        if(add!=null)
            result="정상적으로 삭제됨";
        else
            result="삭제과정 오류 발생";
        return result;
    }

    public String updateStudent(int studentId, StudentDto studentDto){
        Student foundStudent = studentRepository.findById(studentId);
        foundStudent.setPoint(studentDto.getPoint());
        studentRepository.update(studentId,foundStudent);


        //학점만 고치겠다! DTO사용하기

        return "수정완료";
    }
}


