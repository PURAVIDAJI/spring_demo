package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct()
    {
        return productRepository.findall();
    }

    public Product getProduct(int productId){
        return productRepository.findById(productId);

    }

    public String addProduct(Product product){
        String result="";
        Product inserted = productRepository.insert(product);
        if(inserted ==null)
            result="정상적으로 추가됨";
        else
            result="추가과정 오류 발생";
        return result;


    }

    public String updateProduct(int productId, ProductDto productDto){

        String result ="";
        Product product = productRepository.findById(productId);
        product.setQty(productDto.getQty());
        Product updated = productRepository.updateProduct(productId, product);

        if(updated !=null)
            result="업테이트 성공";
        else
            result="업데이트 실패";

        return result;
    }

    public String delete(int productId){
        Product deleted = productRepository.deleteProduct(productId);
        String result ="";
        if(deleted != null)
            result="정상적으로 삭제됨";
        else
            result="삭제과정 오류 발생";
        return result;
    }



}
