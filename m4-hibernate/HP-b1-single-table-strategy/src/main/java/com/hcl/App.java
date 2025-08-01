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
		 *   select * from staff; only single table will be created
      dtype       | staffid |     name      |   phone    | qualification | subject  |   area
------------------+---------+---------------+------------+---------------+----------+----------
 TeachingStaff    |     101 | Amit Singh    | 998877665  | MCA           | Python   |
 TeachingStaff    |     102 | Manoj Mishra  | 888877665  | M.Tech        | Java     |
 TeachingStaff    |     103 | Hemant Pandey | 668877665  | MCA           | Database |
 NonTeachingStaff |     104 | Imran Ahmad   | 9878877665 |               |          | Sales
 NonTeachingStaff |     105 | Kapil Mishra  | 1238877665 |               |          | Accounts
(5 rows)
		 */
    }
}
