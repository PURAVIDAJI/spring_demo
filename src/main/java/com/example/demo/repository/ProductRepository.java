package com.example.demo.repository;

import com.example.demo.model.Post;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductRepository {


    List<Product> findall();
    Product findById(int productId);

    Product insert(Product product);

    Product deleteProduct(int productId);

    Product updateProduct(int productId,Product product);



}
