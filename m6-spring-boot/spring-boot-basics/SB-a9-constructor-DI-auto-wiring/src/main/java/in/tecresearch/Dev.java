package in.tecresearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired //Field DI autowiring
    @Qualifier("laptop")
    private Computer computer;
//    @Autowired//setter DI autowiring
//    private void setComputer(Computer computer){
//        this.computer=computer;
//    }
////    @Autowired// Default autowiring here no need to autowired its automatically done
//    Dev(Computer computer){
//        this.computer=computer;
//    }
    public void code(){
        System.out.println("Coding....");
        computer.compile();
        System.out.println("Completed");
    }
}
