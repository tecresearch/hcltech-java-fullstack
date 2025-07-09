package in.tecresearch;

import in.tecresearch.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static  void main(String []a){
        System.out.println("Application Started...");

        Configuration config=new Configuration();
        Configuration configured=config.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory=configured.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println("Configuration has been successfully done");
//Insert Operaration-------------------------------------------------------------
        User user1=new User(8,"Brijesh ","bnlv121@gmail.com","1245","male","varanasi");
        try {
            session.save(user1);
            transaction.commit();
            System.out.println("Saved successfully: "+user1);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("User details not added due to some error");
        }
//Get single object from database;
        try {
            User duser=session.get(User.class,2);
            System.out.println("Fetched User: "+duser);
        } catch (Exception e) {
            System.out.println("User not found");
        }
//Gett all object from databases;

        try{
            Query<User> query=session.createQuery("from User",User.class);
            List<User> users=query.list();
            for(User user:users){
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
