package com.hcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.NonTeachingStaff;
import com.hcl.model.TeachingStaff;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=HibernateUtil.getFactory();
		Session session=factory.openSession();
		Transaction tr=session.getTransaction();
		tr.begin();
		session.persist(new TeachingStaff(101,"Amit Singh","998877665","MCA","Python"));
		session.persist(new TeachingStaff(102,"Manoj Mishra","888877665","M.Tech","Java"));
		session.persist(new TeachingStaff(103,"Hemant Pandey","668877665","MCA","Database"));
		session.persist(new NonTeachingStaff(104,"Imran Ahmad","9878877665","Sales"));
		session.persist(new NonTeachingStaff(105,"Kapil Mishra","1238877665","Accounts"));
		tr.commit();
		/*
		 *  hcltech=# select * from staff;  tables will be created for each child table and there is no relation to each other
 staffid | name | phone
---------+------+-------
(0 rows)


hcltech=# select * from teachingstaff;
 staffid |     name      |   phone   | qualification | subject
---------+---------------+-----------+---------------+----------
     101 | Amit Singh    | 998877665 | MCA           | Python
     102 | Manoj Mishra  | 888877665 | M.Tech        | Java
     103 | Hemant Pandey | 668877665 | MCA           | Database
(3 rows)


hcltech=# select * from nonteachingstaff;
 staffid |   area   |     name     |   phone
---------+----------+--------------+------------
     104 | Sales    | Imran Ahmad  | 9878877665
     105 | Accounts | Kapil Mishra | 1238877665
		 */
    }
}
