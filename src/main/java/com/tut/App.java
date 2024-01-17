package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        // creating new Student
        Student student=new Student();
        student.setId(5);
        student.setName("Aakash");
        student.setCity("Satara");
        
        System.out.println(student);   
        
        Address ad=new Address();
        ad.setStreet("street 2");
        ad.setCity("Satara");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(101.0);
        
        // For reading Image
        
        FileInputStream fis=new FileInputStream("src/main/java/FullSizeRender.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        session.save(ad);
        tx.commit();

        session.close();
        System.out.println("Done");
    }
}
