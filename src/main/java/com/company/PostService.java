package com.company;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class PostService {

    @Inject
    private PostRepsitory postRepsitory;
    private Post newPost = new Post();
    private PostFacesUtils facesUtils = new PostFacesUtils();
    private List<Post> post = new ArrayList<>();

    public void submitPost() throws IOException {
        post.add(newPost);
        newPost = new Post();
        save();
        facesUtils.redirect();
    }

    public void save() {
        try {
            postRepsitory.save(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void load(){
        post = postRepsitory.load();
    }

    public void deletePost(int i) {
        System.out.println(i);
        this.post.remove(i);
    }

    public void removePost() {
        post.remove(newPost);
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
