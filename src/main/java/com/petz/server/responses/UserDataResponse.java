package com.petz.server.responses;

import com.petz.server.entity.UserData;

public class UserDataResponse {
    private String name;
    private String phoneNumber;
    private String city;

    public UserDataResponse(UserData ud){
        name=ud.getName();
        phoneNumber=ud.getPhoneNumber();
        city=ud.getCity();
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

}
