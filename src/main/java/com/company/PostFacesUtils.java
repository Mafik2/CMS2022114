package com.company;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.Map;
@RequestScoped
@Named
public class PostFacesUtils {
    private Post post;
    @Inject
    private PostService postService;

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    public String getParam(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("id");
    }
    public Post getPost() {
        this.post = this.postService.getById(getParam());
        return post;
    }
}
