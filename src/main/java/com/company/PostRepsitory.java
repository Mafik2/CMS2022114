package com.company;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

}
