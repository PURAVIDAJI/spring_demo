package com.example.demo.viewController;


import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view")
public class ViewController{

    @GetMapping("/text")
    public String method1(Model m){
        //.html으로 리턴할것이다
        //jsp는 request를 통해서 값전달하지만
        //spring에서는 model을 통해서 값을 전달한다.
        m.addAttribute("data","helloWorld");
        //data에 helloWorld담아서 모델 통해서 뷰로 보냄
        return "text";
    }

    @GetMapping("/object")
    public String method2(Model m){
        Student student= new Student();
        student.setName("PARKJISU");
        student.setMajor("Computer Science");
        m.addAttribute("student",student);
        //스트링으로 다운캐스팅을 알아서 해준다.
        return "obj";
    }

    @GetMapping("/link")
    public String method3(Model m){
        m.addAttribute("param1",3);
        m.addAttribute("param2",8);
        return "link";
    }


    @GetMapping("/param")
    public String method4(@RequestParam int param1,
                          @RequestParam int param2,
                          Model m){

        m.addAttribute("result",param1+param2);
        //스트링으로 다운캐스팅을 알아서 해준다.
        return "param";
    }







}
