package com.hibernate.aplab8;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.AnnotationConfiguration;
public class Main {
public static void main(String[] args)
{
	System.out.println("Adding Two new Students\n\n\n\n");
	//Create New Student;
	Student firststudent = new Student("Ali","Hassaan",1736272,"pass","September");
	Student secondstudent = new Student("Tarmah Bin","Iqbal",16242,"pass","October");
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(firststudent);
	session.save(secondstudent);
	session.getTransaction().commit();
	
	//Update a Record From Table
	System.out.println("Update a Record From Table with id = 1736272\n\n\n");
		Query query = session.createQuery("from Student where id=\'1736272\'");
		List<Student> list=query.list();  
		Iterator<Student> itr=list.iterator();  
		if(itr.hasNext()){  
			Student emp=itr.next();  
			System.out.println("Old Student: "+emp.toString());
			session.beginTransaction();
			emp.first="New Ali";
			session.save(emp);
			session.getTransaction().commit();
			System.out.println("New Student: "+emp.toString());
			
		}
		
	//Printing All Records From Table
	System.out.println("Printing All Records From Table\n\n\n");
	query = session.createQuery("from Student");
	list=query.list();  
	itr=list.iterator();  
	while(itr.hasNext()){  
		Student emp=itr.next();  
		System.out.println(emp.toString());  
	} 
	//Delete a Record From Table
	System.out.println("Deleting a Record with Reg id : 1736272\n\n\n");
			query = session.createQuery("from Student where id=\'1736272\'");
			list=query.list();  
			itr=list.iterator();  
			if(itr.hasNext()){  
				Student emp=itr.next();  
				session.beginTransaction();
				session.delete(emp);
				session.getTransaction().commit();
				
	}
}
}
