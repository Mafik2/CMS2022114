package com.company;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class PostService {

    private Post newPost = new Post();
    private List<Post> post = new ArrayList<>();

    public void submitPost() {
    post.add(newPost);
    newPost = new Post();
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
