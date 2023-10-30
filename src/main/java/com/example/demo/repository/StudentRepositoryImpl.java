package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
//서비스한테 주입할 거댜~~~
public class StudentRepositoryImpl implements StudentRepository{


    private static Map<Integer,Student> studentMap = new HashMap<>();
    private static int seq =0;

    public StudentRepositoryImpl() {

        Student student = new Student();
        student.setStudentId(1);
        student.setName("냥냥냥");
        student.setMajor("원자력공학과");
        student.setPoint(3.8F);

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
        //컬렉션을 어레이리스트로 바꿔서 넘긴다.
    }

    @Override
    public Student findById(int studentId) {
        Student student = studentMap.get(studentId);
        return student;
    }

    @Override
    public Student removeById(int studentId) {
        Student remove = studentMap.remove(studentId);
        //정상적으로 지워지면 remove안에 student 객체가 담길 것이다.
        //키랑 매핑되는 게 아무것도 없으면, null로 처리됨
        //로직 처리에 remove가 null이면 문제 있다는 로직 처리 해줘야함.

        return remove;
    }

    @Override
    public Integer add(Student student) {
        Integer result=null;
        student.setStudentId(++seq);
        Student addedStudent = studentMap.put(seq, student);
        if(addedStudent!=null)
            result=student.getStudentId();
        return result;

        //put만 넣고 서비스는 서비스에서 해줘야 함
    }

    @Override
    //서비스가 넘겨준 변수 받아와서
    public Student update(int studentId, Student student) {
        if(findById(studentId)!=null)
            studentMap.put(seq,student);
        else add(student);
        return student;
    }
}
