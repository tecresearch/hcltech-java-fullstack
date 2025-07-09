package in.tecresearch;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements  Computer{
    @Override
    public void compile() {
        System.out.println("Laptop compiling via alien");
    }
}
