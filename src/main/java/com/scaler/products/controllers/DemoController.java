package com.scaler.products.controllers;


import com.scaler.products.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello/1")
    public String sayHello() {
        return "Hello World finally";
    }

}
