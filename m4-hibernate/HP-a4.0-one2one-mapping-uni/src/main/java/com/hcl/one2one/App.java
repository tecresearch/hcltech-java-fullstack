/*
 * 
Unidirectional: Only one entity knows about the relationship.
Bidirectional: Both entities are aware and maintain references to each other.
mappedBy: Indicates the inverse side of the relationship (non-owning side).
@JoinColumn / @JoinTable: Used to define foreign key or join table details
----------------------------------------------------------------------------

Hibernate Association Mapping Overview

Association Type	Direction		Annotation Example					Description
[DONE*] One-to-One	Unidirectional	@OneToOne @JoinColumn				One entity holds a reference to another. Only one side is aware of the relationship.
One-to-One			Bidirectional	@OneToOne(mappedBy) + @JoinColumn	Both entities reference each other. One side owns the relationship, the other maps it.

One-to-Many			Unidirectional	@OneToMany @JoinColumn				One entity holds a collection of another. The child does not reference the parent.
One-to-Many			Bidirectional	@OneToMany(mappedBy) + @ManyToOne	Parent holds a collection, and child holds a reference back to the parent.

Many-to-One			Unidirectional	@ManyToOne @JoinColumn				Many child entities reference one parent. Common in bidirectional One-to-Many.
Many-to-One			Bidirectional	@ManyToOne @JoinColumn+@OneToMany(mappedBy)	Many child entities reference one parent. Both child and parent entities are aware of each other.

Many-to-Many		Unidirectional	@ManyToMany @JoinTable				One entity holds a collection of another. The other side is unaware of the relationship.
Many-to-Many		Bidirectional	@ManyToMany(mappedBy) + @JoinTable	Both entities hold collections of each other. A join table manages the relationship.

 */
/*
 * 
 * 1. One-to-One Mapping
 * 
Unidirectional
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
}
Bidirectional
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private Address address;
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String street;
}





2. One-to-Many Mapping
Unidirectional
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Employee> employees;
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
Bidirectional
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String name;
}
3. Many-to-One Mapping
Unidirectional
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String name;
}


Bidirectional Mapping
Employee Class
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id") // Foreign key column
    private Department department;

    private String name;

    // Getters and Setters
}
Department Class
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department") // Reference to the Employee entity
    private List<Employee> employees = new ArrayList<>();

    // Getters and Setters
}
Key Changes:
In the Department class:
Added a List<Employee> to hold the employees that belong to the department.
Used the @OneToMany annotation with mappedBy = "department" to indicate that the Employee entity owns the relationship.


4. Many-to-Many Mapping
Unidirectional
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
Bidirectional
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    private String title;
}

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package com.hcl.one2one;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.one2one.unidirectional.model.Address;
import com.hcl.one2one.unidirectional.model.User;

 
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
       
       Address adr2=new Address();
       adr2.setVillage("Pari Chowk");
       adr2.setCity("Greater Noida");
       adr2.setState("Uttar Pradesh");
       adr2.setPin(201310);
       adr2.setCountry("India");
       
       Address adr3=new Address();
       adr3.setVillage("Pari Chowk");
       adr3.setCity("Greater Noida");
       adr3.setState("Uttar Pradesh");
       adr3.setPin(201310);
       adr3.setCountry("India");
       
       User user1=new User();
       user1.setFirstName("Brijesh");
       user1.setLastName("Nishad");
       user1.setAddress(adr1);
       
       User user2=new User();
       user2.setFirstName("Santosh");
       user2.setLastName("Nishad");
       user2.setAddress(adr2);

       
       User user3=new User();
       user3.setFirstName("Mokesh");
       user3.setLastName("Nishad");
       user3.setAddress(adr3);

      session.persist(user1);
      session.persist(user2);
      session.persist(user3);
      
      
       transaction.commit();
       System.out.println("Users Saved successfully");
    // Assuming 'session' is already defined and initialized
       List<String> uniqueFirstNames = session.createQuery("from User", User.class)
           .list()
           .stream()
           .map(User::getFirstName) // Extract first names
           .distinct() // Filter duplicates
           .collect(Collectors.toList()); // Collect to a list

       System.out.println(uniqueFirstNames);
       
    // Assuming 'session' is already defined and initialized
       List<String> modifiedUserDetails = session.createQuery("from User", User.class)
           .list()
           .stream()
           .map(user -> "Mr " + user.getFirstName() + " " + user.getLastName() + "_dev, Address: " + user.getAddress()) // Modify names and include address
           .distinct() // Filter duplicates
           .collect(Collectors.toList()); // Collect to a list

       System.out.println(modifiedUserDetails);
     
    
   
    }
}
