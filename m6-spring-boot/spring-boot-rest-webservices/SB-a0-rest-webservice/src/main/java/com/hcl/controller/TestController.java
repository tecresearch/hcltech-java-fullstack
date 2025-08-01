package com.hcl.controller;

import com.hcl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
// @Controller // Uncomment this line to use a regular controller instead of a REST controller
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/test")
    public Map<String,Map<String,String>> getMessage() {
        return  testService.testService();
    }
}
