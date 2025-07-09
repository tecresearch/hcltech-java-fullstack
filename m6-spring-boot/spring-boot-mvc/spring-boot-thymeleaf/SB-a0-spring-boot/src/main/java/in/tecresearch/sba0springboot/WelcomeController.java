package in.tecresearch.sba0springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("myapp")
public class WelcomeController {

    @GetMapping("/welcome")
    public String Welcome(){
        return "index";
    }

}
