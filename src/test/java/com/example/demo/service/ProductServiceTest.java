package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepositotyImpl;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;



@SpringBootTest
class ProductServiceTest {


  ProductRepository productRepository= new MemoryProductRepositotyImpl();

  ProductService productService = new ProductService(productRepository);

  @Test
    void 새로운제품추가(){

    Product product = Product.builder()
            .productName("테스트1")
            .maker("test")
            .price(1000)
            .qty(100)
            .build();

    String s = productService.addProduct(product);
    assertThat(s).isEqualTo("정상적으로 추가됨");

    //assertThat(productService.getAllProduct().size()).isEqualTo(2);


  }




}