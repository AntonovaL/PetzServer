package com.petz.server.responses;

import com.petz.server.entity.UserData;

public class UserDataResponse {
    private String name;
    private String phoneNumber;
    private String city;
    private String type;

    public UserDataResponse(UserData ud){
        name=ud.getName();
        phoneNumber=ud.getPhoneNumber();
        city=ud.getCity();
        type=ud.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(String type){this.type=type;}

    public String getType(){
        return type;
    }

}
