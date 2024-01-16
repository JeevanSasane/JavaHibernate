package com.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        // creating new Student
        Student student=new Student();
        student.setId(2);
        student.setName("Jeevan");
        student.setCity("Satara");
        
        System.out.println(student);   
       
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();

        session.close();
    }
}
