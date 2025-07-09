package in.tecresearch;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private  Computer computer;

    @Resource //can we use @Autowired also
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code(){
        System.out.println("coding....");
        computer.compile();
        System.out.println("Completed");
    }
}
