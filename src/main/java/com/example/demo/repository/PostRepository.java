package com.example.demo.repository;

import com.example.demo.model.Post;

import java.util.List;

public interface PostRepository {

    //crud 들어가야 함.

    List<Post> selectAllPosts();

    Post selectPostById(int postId);

    void deletePost(int postId);

    int insertPost(Post post);

    void updatePost(Post post);


    //내용만 바꾸는 update, likes만 바꾸는 update 나누는 게 좋음

}
