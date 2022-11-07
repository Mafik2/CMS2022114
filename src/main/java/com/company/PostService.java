package com.company;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class PostService {

    private Post newPost = new Post();
    private List<Post> post = new ArrayList<>();

    public void save() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("post.json"));
        bw.write(newPost.getArticle());
        bw.close();
    }

    public void submitPost() {
        post.add(newPost);
        newPost = new Post();
    }
    public void deletePost(int i){
        System.out.println(i);
        this.post.remove(i);
    }

    public Post getNewPost() {
        return newPost;
    }

    public void setNewPost(Post newPost) {
        this.newPost = newPost;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
