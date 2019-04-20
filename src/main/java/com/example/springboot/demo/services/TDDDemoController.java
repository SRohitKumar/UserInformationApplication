package com.example.springboot.demo.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class TDDDemoController {

    @GetMapping("/UserInfo")
    public static String getName(@RequestParam String userId) {

        if(!userId.isEmpty() && userId.equals("RXK8291")) {
            return "Rohit Kumar";
        } else {
            return "User is Invalid";
        }
    }

    //use this http://localhost:9090/User/UserInfo?userId=RXK8291
}
