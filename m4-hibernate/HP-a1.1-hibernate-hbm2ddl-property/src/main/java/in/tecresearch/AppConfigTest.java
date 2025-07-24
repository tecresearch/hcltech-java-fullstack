package in.tecresearch;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class AppConfigTest
{
    public static void main( String[] args )
    {
        System.out.println( "Application Started...." );
        //Command to create object of SessionFactory interface
        Configuration cn=new Configuration();
        cn.configure("hibernate.cfg.xml");
        SessionFactory factory1=cn.buildSessionFactory();
        //Command to create object of SessionFactory interface
        SessionFactory factory2=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println( " Hibernate SessionFactoryConfiguration Successfully completed" );

    }
}
