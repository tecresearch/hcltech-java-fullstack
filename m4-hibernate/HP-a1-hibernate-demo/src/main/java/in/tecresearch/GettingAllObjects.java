package in.tecresearch;

import java.util.List;

import in.tecresearch.model.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GettingAllObjects
{
    public static void main( String[] args )
    {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        Query<Product> query=session.createQuery("from Product",Product.class);
        List<Product> productList= query.list();
        for(Product product:productList)
        {
        	System.out.println(product);
        }
    }
}
