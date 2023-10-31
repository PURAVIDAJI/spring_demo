package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.model.Student;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private  final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    public Product getProductInfo(@PathVariable int productId){
        //누구랑 바인딩 해줄거니? 밖에서 오는 변수와 바인딩해줄거야!
        return productService.getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public String delete (@PathVariable int productId){
        String res = productService.delete(productId);
        return res;
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){

        //아규먼트가 없는 디폴트 컨스트럭터가 있어야,컨스트럭터를 만들 수 있게 된다.
        //@NoArgsConstructor를 가지고 있어야
        String res = productService.addProduct(product);
        return res;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable int productId,
                                @RequestBody ProductDto productDto){
        String res = productService.updateProduct(productId, productDto);
        return res;

    }




}
