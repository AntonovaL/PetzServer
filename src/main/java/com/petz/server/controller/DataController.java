package com.petz.server.controller;

import com.petz.server.entity.UserData;
import com.petz.server.repository.UserDataRepository;
import com.petz.server.requests.UserDataForm;
import com.petz.server.responses.UserDataResponse;
import com.petz.server.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    UserDataRepository userDataRepository;

    @PostMapping("/addUserData")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> addUserData(@Valid @RequestBody UserDataForm userDataForm){
        //UserData ud=new UserData()
        UserPrinciple user=(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id=user.getId();
        UserData ud=new UserData(id,userDataForm.getName(),userDataForm.getPhoneNumber(), userDataForm.getCity(),userDataForm.getType());
        System.out.println(userDataForm.getName());
        userDataRepository.save(ud);
        return ResponseEntity.ok().body("Data added successfully!");
    }

    @GetMapping("/getUserData")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserData(){
        UserPrinciple user=(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id=user.getId();
        try {
            UserData ud = userDataRepository.getOne(id);
            UserDataResponse response=new UserDataResponse(ud);
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e){
            return  new ResponseEntity<String>("Data does'not exists!",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
