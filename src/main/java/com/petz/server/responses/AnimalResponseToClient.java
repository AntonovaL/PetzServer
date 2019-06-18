package com.petz.server.responses;

public class AnimalResponseToClient {
    private int id;

    private String name;

    private float age;

    private String type;

    private String img;

    private String info;

    private String sex;

    private String ownerName;

    private String phoneNumber;

    public String getName(){return name;}
    public void setId(int id){this.id=id;}
    public void setType(String type) {
        this.type = type;
    }

    public void setAge(float age) {
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

    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
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

    public int getId(){return id;}

    public void setOwnerName(String ownerName){this.ownerName=ownerName;}

    public String getOwnerName(){return  ownerName;}

    public String getPhoneNumber(){return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

}
