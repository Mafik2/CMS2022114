package com.company;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class PostRepsitory {

    private Gson gson = new Gson();

    public void save(List<Post> post) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("post.json"));
        bw.write(gson.toJson(post));
        bw.close();
    }

    public List<Post> load(){
        List<Post> post;
        try {
            BufferedReader br = new BufferedReader(new FileReader("post.json"));

            String jsonLine = br.readLine();
            br.close();
            post = new ArrayList<>(List.of(gson.fromJson(jsonLine, Post[].class)));
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return post;
    }
}
