package com.petz.server.entity;

import javax.persistence.*;

@Entity
@Table(name="userdata")
public class UserData {
    @Id
    Integer userId;
    @Column(name="name")
    String name;
    @Column(name="phoneNumber")
    String phoneNumber;
    @Column(name="city")
    String city;

    public UserData(){

    }
    public UserData(int userId, String name, String phoneNumber, String city){
        this.userId=userId;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.city=city;
    }
   public void setUser_id(int userId){
       this.userId=userId;
   }

   public int getUser_id(){
       return userId;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getName(){
        return name;
    }
}
