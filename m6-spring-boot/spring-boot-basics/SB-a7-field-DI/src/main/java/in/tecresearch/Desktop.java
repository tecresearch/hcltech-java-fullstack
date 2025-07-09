package in.tecresearch;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{
    public void compile(){
        System.out.println(" Desktop Compiling....");
    }
    public void completed(){
        System.out.println("Desktop Completed....");
    }
}
