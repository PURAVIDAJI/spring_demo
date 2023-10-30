package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service //컴포넌트이다.
//서비스를 컨트롤에 연결해주쟈. MVC중 M이다. 데이터 처리해주는 쪽

public class PostService {

    @Autowired
    private PostRepository postRepository;

 //서비스 안에서는 비지니스 로직 처리해야함 (원래는)
    public List<Post> getAllPosts(){

        return postRepository.selectAllPosts();
    }

    public Post getPostById(int postId){
        return postRepository.selectPostById(postId);

    }

    public void removePost(int postid){
        postRepository.deletePost(postid);
    }
    public Post setPost(Post post){

       postRepository.insertPost(post);
        return post;

    }

    public Post updatePost(int postId, PostDto postDto){
        Post post1 = postRepository.selectPostById(postId);
        post1.setLikes(postDto.getLikes());
        postRepository.updatePost(post1);
        return post1;
        //왜 원래것을 리턴하지??

    }


}
