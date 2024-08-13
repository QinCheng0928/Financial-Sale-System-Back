package com.demo.product.controller;


import com.demo.domain.UserDTO;

import com.demo.product.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tproduct")
public class TestController {
    @Autowired
    TestMapper testMapper;
    @GetMapping("/test1")
    public UserDTO test(String name){
        System.out.println("--------------test--------------");
        return testMapper.testUserDTO(name);
    }

}
