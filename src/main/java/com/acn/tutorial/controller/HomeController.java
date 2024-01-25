package com.acn.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/num")
    @ResponseBody
    public int number(){
        return 123;
    }


    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "Hi, ich bin eine Schnittstelle!";
    }

    @PostMapping("/multiply/{num}")
    @ResponseBody
    public int multiply(@PathVariable int num){
        return num*7;
    }


    @GetMapping("/multiply/{num1}/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1 , @PathVariable int num2){
        return num1*num2;
    }
}
