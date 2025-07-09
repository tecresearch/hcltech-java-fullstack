package in.tca.bean_life_cycles;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean, DisposableBean {

    private String message;

    public BeanLifeCycle() {
        System.err.println("SECOND: Bean Instantiated: Constructor called.");
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("2.1: Bean Properties Set: Message property set: {"+message+"}");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("THIRD: Bean Initialized: afterPropertiesSet() called.");
    }

    public void customInit() {
        System.out.println("3.1: Custom Init Method: customInit() called.");
    }

    public void printMessage() {
        System.out.println("3.2: Bean in Use: Message is - " + message);
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("FOURTH: Bean Destroyed: destroy() called.");
    }

    public void customDestroy() {
        System.out.println("4.1: Custom Destroy Method: customDestroy() called.");
    }
}