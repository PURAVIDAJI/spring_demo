package com.example.demo.model;

import lombok.Data;

@Data //getter, setter 다 포함함
//@AllArgsConstructor //모든 변수들 포함하는 생성자
public class PostDto {
    private int postid;
    private  int likes;
}
