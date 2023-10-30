package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //얘네를 리파지토리라고 알려주고 나중에 주입시킬 것임
//인터페이스는 인스턴스화 할 수 없기에
//구현체를 인스턴스화 할수 있으므로 이것을 컴포넌트화 한다.

public class PostRepositotyImpl implements PostRepository{
    //postRepository를 구현한 구현체
    //우선은 Map에 데이터를 저장할 것
    //구현체 만들고 조립해줘해서 생성자에 주입시켜야 함.

    private static Map<Integer,Post> posts = new HashMap<>();
    private static int seq =0;



    @Override
    public List<Post> selectAllPosts() {

        return new ArrayList<>(posts.values());
    }

    @Override
    public Post selectPostById(int postId) {
        return posts.get(postId);
        //posts는 매핑된 값이고, .get(key)메서드는 키값을 가져온다.
        //따라서 posts.get(postId)의 경우, postId를 키값으로 가지는 post 객체 한개를 가져온다.

    }

    @Override
    public void deletePost(int postId) {
        posts.remove(postId);
        //여기서도 마찬가지로,
        // Map에서 postId를 키값으로 가지는 맵 내부의 해당 posts 객체를 삭세한다.
    }

    @Override
    public int insertPost(Post post) {
        seq++;
        post.setPostid(seq);
        posts.put(seq,post);

        return post.getPostid();
    }

    @Override
    public void updatePost(Post post) {
        posts.put(post.getPostid(),post);
        //시퀀스가 없으면 추가되고, 시퀀스가 있으면 업데이트되는 것이 MAP이다

    }
}
