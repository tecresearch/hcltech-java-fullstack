/*
 * 
Unidirectional: Only one entity knows about the relationship.
Bidirectional: Both entities are aware and maintain references to each other.
mappedBy: Indicates the inverse side of the relationship (non-owning side).
@JoinColumn / @JoinTable: Used to define foreign key or join table details
----------------------------------------------------------------------------

Hibernate Association Mapping Overview
Association Type	Direction	Annotation Example	Description
One-to-One	Unidirectional	@OneToOne @JoinColumn	One entity holds a reference to another. Only one side is aware of the relationship.
One-to-One	Bidirectional	@OneToOne(mappedBy) + @JoinColumn	Both entities reference each other. One side owns the relationship, the other maps it.
One-to-Many	Unidirectional	@OneToMany @JoinColumn	One entity holds a collection of another. The child does not reference the parent.
One-to-Many	Bidirectional	@OneToMany(mappedBy) + @ManyToOne	Parent holds a collection, and child holds a reference back to the parent.
Many-to-One	Unidirectional	@ManyToOne @JoinColumn	Many child entities reference one parent. Common in bidirectional One-to-Many.
Many-to-Many	Unidirectional	@ManyToMany @JoinTable	One entity holds a collection of another. The other side is unaware of the relationship.
Many-to-Many	Bidirectional	@ManyToMany(mappedBy) + @JoinTable	Both entities hold collections of each other. A join table manages the relationship.

 */

package com.hcl.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.one_to_one.models.Address;
import com.hcl.one_to_one.models.User;

 
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration hibernateContext=new Configuration().configure("hibernate.cfg.xml");
       
       SessionFactory factory=hibernateContext.buildSessionFactory();
       
       Session session=factory.openSession();
       Transaction transaction=session.getTransaction();
       
   
       transaction.begin();
       Address adr1=new Address();
       adr1.setVillage("Pari Chowk");
       adr1.setCity("Greater Noida");
       adr1.setState("Uttar Pradesh");
       adr1.setPin(201310);
       adr1.setCountry("India");
       
       User user1=new User();
       user1.setFirstName("Brijesh");
       user1.setLastName("Nishad");
       user1.setAddress(adr1);
       
       session.save(user1);
       transaction.commit();
       
       System.out.println("Users Saved successfully");
       
   
    }
}
