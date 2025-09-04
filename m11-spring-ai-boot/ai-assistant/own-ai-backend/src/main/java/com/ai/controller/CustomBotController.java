package com.ai.controller;


import com.ai.controller.exception.InvalidCharacterException;
import com.ai.dto.ChatGPTRequest;
import com.ai.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "*")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;


    @GetMapping("")
    public ResponseEntity<Map<String,Object>> chat(@RequestParam("q") String prompt){
        try{

            ChatGPTRequest request=new ChatGPTRequest(model, prompt);
            ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
            Map<String,Object> map1=new LinkedHashMap<>();
            map1.put("version","1.0");
            map1.put("prompt",prompt);

            map1.put("result",chatGptResponse.getChoices().get(0).getMessage().getContent());

            Map<String,Object> map=new LinkedHashMap<>();
            map.put("company","HCLTech");
            map.put("team","tecresearch");
            map.put("name","Brijesh Nishad");
            map.put("role","FullStack Java Developer specialization with Iot and ai");
            map.put("email","bnlv1212@gmail.com");
            map.put("website","https://tecresearch.in");
            map1.put("developer",map);
            return ResponseEntity.status(HttpStatus.OK).body(map1);
        } catch (Exception e) {
            throw new InvalidCharacterException("Remove all special characters");
        }
    }
}
