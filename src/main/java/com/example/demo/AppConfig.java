package com.example.demo;

import com.example.demo.service.AmountOrderService;
import com.example.demo.service.OrderService;
import com.example.demo.service.RateOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {




    //서비스 가서 @service 막음-> 스프링이 자동으로 할당하지 못하도록
    //여기가 어떤 컨트롤러를 쓸지 갈아끼워넣는 장소가 된다.
    @Bean //orderService는 bean이다.
    public OrderService orderService(){

        //return new AmountOrderService();
        return new RateOrderService();
    }

}
