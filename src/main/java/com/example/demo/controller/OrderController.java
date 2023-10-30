package com.example.demo.controller;

import com.example.demo.AppConfig;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/orders")
public class OrderController {

    private final ProductService productService;

    private final OrderService orderService;

    public OrderController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService=orderService;
        //AppConfig appConfig = new AppConfig();
        //orderService  = appConfig.orderService();
    }

    @GetMapping("/{productId}")
    public int getProductPrice(@PathVariable int productId){
        Product product = productService.getProduct(productId);
        int price = orderService.getPrice(product.getPrice());

        return price;
    }
}
