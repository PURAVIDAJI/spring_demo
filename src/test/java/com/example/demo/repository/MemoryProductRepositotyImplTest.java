package com.example.demo.repository;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositotyImplTest {

    ProductRepository productRepository = new MemoryProductRepositotyImpl();


    @BeforeEach
    void setUp() {
    }
    @Test
    void findAll(){

        List<Product> allProducts = productRepository.findall();
        System.out.println(allProducts.size());
        org.assertj.core.api.Assertions.assertThat(allProducts.size()).isEqualTo(1);
    }

    @Test
    void findById(){
        Product product = productRepository.findById(1);
        org.assertj.core.api.Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");

    }

    @Test
    void insert(){
        Product product = Product.builder()
                    .productName("테스트2")
                    .maker("테스트메이커")
                    .price(1000)
                    .qty(1200)
                    .build();

        Product insertproduct = productRepository.insert(product);
        org.assertj.core.api.Assertions.assertThat(insertproduct.getProductId()).isEqualTo(2);


    }

    @Test
    void deleteProduct(){

        productRepository.deleteProduct(1);
        org.assertj.core.api.Assertions.assertThat(productRepository.findall().size()).isEqualTo(0);

    }


    @Test
    void updateProduct(){
        Product product = Product.builder()
                .productName("테스트2")
                .maker("테스트메이커")
                .price(1000)
                .qty(12)
                .build();
        Product product1 = productRepository.updateProduct(1, product);
        org.assertj.core.api.Assertions.assertThat(productRepository.findById(1).getQty()).isEqualTo(12);
    }

}