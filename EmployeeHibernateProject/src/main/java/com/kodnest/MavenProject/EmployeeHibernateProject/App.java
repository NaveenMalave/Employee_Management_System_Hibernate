package com.kodnest.MavenProject.EmployeeHibernateProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	static Scanner sc = new Scanner(System.in);
	static SessionFactory factory;
    public static void main( String[] args )
    {
    	factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        while(true) {
        	System.out.println("PRESS-1 ---> CREATE");
        	System.out.println("PRESS-2 ---> READ");
        	System.out.println("PRESS-3 ---> UPDATE");
        	System.out.println("PRESS-4 ---> DELETE");
        	System.out.println("OTHER NUMBER ---> STOP");
        	int choice = sc.nextInt();
        	switch (choice) {
            case 1:
                CreateUser();
                break;
            case 2:
                ReadUser();
                break;
            case 3:
                UpdateUser();
                break;
            case 4:
                DeleteUser();
                break;
            default:
                System.out.println("THANK YOU FOR USING KODNEST EMS");
                break;
        }
        }
        
    }
    
    public static void CreateUser() {
    	System.out.println("ENTER EMPLOYEE NAME, PASSWORD,SALARY AND ADDRESS ");
    	
          String name =sc.next();
          int password = sc.nextInt();
          int salary = sc.nextInt();
          String address = sc.next();
     
    	EmployeeDetails emp = new EmployeeDetails(name,password,salary,address);
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	session.persist(emp);
    	transaction.commit();
    	session.close();
    }
    public static void ReadUser() {
    	System.out.println("ENTER EMPLOYEE ID");
    	int id = sc.nextInt();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	EmployeeDetails e = (EmployeeDetails)session.get(EmployeeDetails.class, id);
    	System.out.println("ID | NAME | PASSWORD | SALARY | ADDRESS");
    	System.out.println(e);
    }
    public static void UpdateUser() {
    	System.out.println("ENTER EMPLOYEE ID TO UPDATE");
    	int id = sc.nextInt();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	EmployeeDetails e = (EmployeeDetails) session.get(EmployeeDetails.class, id);
    	if(e!=null) {
    		System.out.println("PRESS-A TO UPDATE NAME");
    		System.out.println("PRESS-B TO UPDATE PASSWORD");
    		System.out.println("PRESS-C TO UPDATE SALARY");
    		System.out.println("PRESS-D TO UPDATE ADDRESS");
    		char choice = sc.next().charAt(0);
    		System.out.println("Enter new Data");
    		switch (choice) {
    	    case 'A':
    	        e.setName(sc.next());
    	        break;
    	    case 'B':
    	        e.setPassword(sc.nextInt());
    	        break;
    	    case 'C':
    	        e.setSalary(sc.nextInt());
    	        break;
    	    case 'D':
    	        e.setAddress(sc.next());
    	        break;
    	    default:
    	        System.out.println("");
    	        return;
    	}
    	
    	session.merge(e);
    	transaction.commit();
    	session.close();
    	
    }else {
    	System.out.println("INVALID EMPLOYEE ID PLEASE TRY AGAIN....");
    }
    }
    public static void DeleteUser() {
    	System.out.println("ENTER EMPLOYEE ID TO DELETE");
    	int id = sc.nextInt();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	EmployeeDetails e = (EmployeeDetails) session.get(EmployeeDetails.class, id);
    	if(e!=null) {
    		System.out.println(e);
    		System.out.println("IS REMOVED");
    		session.remove(e);
    		transaction.commit();
    		session.close();
    	}else {
    		System.out.println("invalid employee id please try again");
    	}
    }
    
}
