package com.enesselvi.lil.booting;

import jakarta.servlet.http.PushBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping()
    public String testApp(){

        return "App is Running";
    }
}
