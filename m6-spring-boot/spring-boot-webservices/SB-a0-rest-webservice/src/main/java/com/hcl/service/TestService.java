package com.hcl.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    public Map<String, Map<String, String>> testService() {
        Map<String,Map<String,String>> map = new HashMap<>();
        Map<String,String> data1= new HashMap<>();
        data1.put("id","1");
        data1.put("name","HCL");
        data1.put("location","Chennai");
        Map<String,String> data2= new HashMap<>();
        data2.put("id","2");
        data2.put("name","HCL Technologies");
        data2.put("location","Chennai");
        map.put("data1",data1);
        map.put("data2",data2);
        return map;
    }
}
