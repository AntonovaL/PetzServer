package com.petz.server.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private int animalId;
    @Column(name="ownerid",nullable=false)
    private int ownerId;
    @Column(name="name")
    private String name;
    @Column (name="type")
    private String type;
    @Column (name="age")
    private float age;
    @Column (name="info")
    private String info;
    @Column (name="photo")
    private String photo;
    @Column (name="sex")
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public float getAge() {
        return age;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex) {
        this.sex=sex;
    }
}
