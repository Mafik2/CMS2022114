package com.company;

import jakarta.faces.context.FacesContext;

import java.io.IOException;
import java.util.Map;

public class PostFacesUtils {
    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    public String getParam(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        return params.get("a");
    }
}
