package in.tecresearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("spring-boot-app")
public class MyController {

    @GetMapping("/v1/data1")
    @ResponseBody
    public String myData1(){
        return "My data 1 from controller";
    }
    @GetMapping("/v1/data2")
    @ResponseBody
    public String myData2(){
        return "My data 2 from controller";
    }
    @GetMapping("/v2/data3")
    @ResponseBody
    public String myData3(){
        return "My data 3 from controller";
    }
    @GetMapping("/v2/data4")
    @ResponseBody
    public String myData4(){
        return "My data 4 from controller";
    }

}
