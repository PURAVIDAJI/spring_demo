package com.example.demo.webcontroller;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.model.Student;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class WebPostController {

    private  PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/view")
    public String viewAllPosts(Model m){
        List<Post> allPosts = postService.getAllPosts();
        m.addAttribute("posts",allPosts);

        return "post/postList";
    }

    @PostMapping("/view")
    public String insertPosts(@ModelAttribute Post post){
        postService.setPost(post);

        return "redirect:/posts/view";
        //뷰로 보내주는 게 맞았네?????? 위의
    }


    @GetMapping("/detail/{postId}")
    public String viewPostById(@PathVariable int postId, Model m){
        Post postById = postService.getPostById(postId);
        m.addAttribute("post",postById);
        return "post/postInfo";
    }

    @PostMapping("/delete/{postId}")
    public String removePost(@PathVariable int postId) {
        postService.removePost(postId);
        return "redirect:/posts/view";
        //다시 뷰로 보내줘야함. -> 리다이렉트에서는 뷰로 보내주는 게 맞다!
    }




 //업데이트 부분만 수정하면 됨
    @GetMapping("/update/{postId}")
    public String updatePost(@PathVariable int postId, Model m){

        Post postById = postService.getPostById(postId);
        m.addAttribute("targetPost", postById);

        return "post/postEdit";
    }

    @PostMapping("/update/{postId}")
    public String updatePost(@PathVariable int postId,
                             @ModelAttribute PostDto postDto){


        postService.updatePost(postId,postDto);



        return "redirect:/posts/view";
    }






}

