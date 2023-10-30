package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    //


    private  PostService postService;
    //2. 외부에서 필드 주입 받음 -> Autowired 애노테이션을 사용.

    //---final -> 생성자나 세터로 할 때,
    //값 지정시 못바꾸게 생성할때만, 1번 설정하고 변경 불가능
    // 외부에서 수정 불가능

    //3.세터로 주입하기 --잘 사용하지 않음
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }



//1. 생성자로 주입받기 --한개 가져올때는 Autowired 생략해도 자동으로 주입을 해준다.

//    public PostController(PostService postService){
//        this.postService = postService;
//        //너 생성될때 서비스도 주입해줘
//
//    }


    @GetMapping("/posts")
    public List<Post> viewAllPosts(){
        List<Post> allPosts = postService.getAllPosts();
        //올포스트 전부 다 받아와서 변수에 저장한뒤에 리턴시킴
        System.out.println(allPosts);
        return allPosts;

    }

    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable int postId){
        return postService.getPostById(postId);
    }

    @DeleteMapping("/posts/{postId}")
    public void removePost(@PathVariable int postId){
        postService.removePost(postId);
    }


    @PostMapping("/posts")
    public Post registPost(@RequestBody Post post){
        //post 각각의 속성에 바인딩 해줌
        System.out.println("before==>"+ post);
        postService.setPost(post);
        System.out.println("after ==>" + post);
        return post;
    }

    @PutMapping("/posts/{postId}")
    public String updatePost(@PathVariable("postId") int postId, @RequestBody PostDto postDto){
        //바꿀 내용은 RequestBody에게 넘김
        System.out.println("before==>"+ postDto);
        postService.updatePost(postId,postDto);
        System.out.println("after==>"+ postDto);

        return "업데이트 완료";
    }

}

