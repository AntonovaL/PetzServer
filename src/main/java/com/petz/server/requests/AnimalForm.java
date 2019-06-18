package com.petz.server.requests;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.File;

public class AnimalForm {
    @NotBlank
    private String name;

    @NotBlank
    private String age;

    @NotBlank
    private String type;

    @NotBlank
    private String img;

    @NotBlank
    private String info;

    @NotBlank
    private String sex;

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return img;
    }

    public String getAge() {
        return age;
    }

    public void setFile(String img) {
        this.img = img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSex(String sex){
        this.sex=sex;
    }

    public String getSex(){
        return sex;
    }

}
