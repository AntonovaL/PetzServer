package com.petz.server.controller;

import com.petz.server.entity.User;
import com.petz.server.repository.UserRepository;
import com.petz.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="/test",method= RequestMethod.GET)
    @ResponseBody
    public List<User> testGetAll(){
        List<User> list=testService.getAll();
        return list;
    }

    @RequestMapping(value="test/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User testGetOne(@PathVariable("id") int userId){
        return testService.getById(userId);
    }

    @RequestMapping(value="testDelete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void testDelete(@PathVariable("id") int userId){
        testService.delete(userId);
    }
    @RequestMapping(value="testSave",method = RequestMethod.POST)
    @ResponseBody
    public User testSave(@RequestBody User user){
        return testService.save(user);
    }





}
