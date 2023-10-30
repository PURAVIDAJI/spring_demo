package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //getter, setter 다 포함함
//@AllArgsConstructor //모든 변수들 포함하는 생성자
public class Post {
    private int postid;
    private String title;
    private String body;
    private  int likes;

}
