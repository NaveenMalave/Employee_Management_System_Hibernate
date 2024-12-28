package com.kodnest.MavenProject.HiberateFirst;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		Student s = new Student(5,2454,"krishna",33);
		// Step-1 : loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
        
		//Step-2 : Build session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//step - 3 : open session
		Session session =  factory.openSession();
		//step-4 : begin transaction
		Transaction transaction = session.beginTransaction();
		//step- 5 perform operation
		session.persist(s);
		//step - 6  commit trasactionss
		transaction.commit();
		//step- 7 close session
		session.close();;
		//step-8 : close sessionfactiory
		factory.close();
		
		
	}
}
