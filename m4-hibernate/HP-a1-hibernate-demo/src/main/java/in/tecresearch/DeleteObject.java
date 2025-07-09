package in.tecresearch;

import in.tecresearch.model.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DeleteObject 
{
    public static void main( String[] args )
    {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        Product product=session.get(Product.class,101123);
        if(product!=null)
        {
        	Transaction t=session.getTransaction();
        	t.begin();
        	session.delete(product);
        	t.commit();
        }
        else
        	System.out.println("Record not found");
    }
}
