package com.example.demo.viewController;


import com.example.demo.model.Product;
import com.example.demo.model.Student;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController{

    private final ProductService productService;

    @Autowired
    public ViewController(ProductService productService) {
        this.productService = productService;
    } //생성자 통해서 주입 받기...!



    @GetMapping("/products")
    public String method0(Model m){
        List<Product> allProduct = productService.getAllProduct();
        m.addAttribute( "products",allProduct);
        return "productList";
    }

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

    @GetMapping("/param/{param1}/{param2}")
    public String method5(@PathVariable int param1,
                          @PathVariable int param2,
                          Model m){

        m.addAttribute("result",param1+param2);
        //스트링으로 다운캐스팅을 알아서 해준다.
        return "param";
    }

    @GetMapping("/param/{param1}")
    public String method6(@PathVariable int param1,
                          @RequestParam int param2,
                          Model m){

        m.addAttribute("result",param1+param2);
        //스트링으로 다운캐스팅을 알아서 해준다.
        return "param";
    }

    @GetMapping("/student")
    public String method7(){
        return "studentForm";
    }

    @PostMapping("/student")
    @ResponseBody
    public Student method8(@ModelAttribute Student student){


        return student;
        //json으로 리스폰스 바디에 담아서 응답시킨다.

    }










}
