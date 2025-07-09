package in.tecresearch;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary single component must be primary
public class Laptop implements  Computer{
    public void compile(){
        System.out.println("Laptop Compiling....");
    }
    public void completed(){
        System.out.println("Laptop Completed....");
    }
}
