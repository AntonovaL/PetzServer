package com.petz.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private int userId;
    @Column(name="userName",nullable=false, length = 30)
    private String userName;
    @Column(name="password", nullable = false,length = 30)
    private String password;
    @Column(name="type",nullable = false,length = 30)
    private String type;

    public User(){

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getType(){
        return type;
    }


}
