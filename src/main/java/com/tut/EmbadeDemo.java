package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbadeDemo {

    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Student student1=new Student();
        student1.setId(8);
        student1.setCity("Pune");
        student1.setName("Prakash");

        Certificate certificate=new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("5 Months");
        student1.setCertificate(certificate);

        Student student2=new Student();
        student2.setId(9);
        student2.setCity("Satara");
        student2.setName("Kiran");

        Certificate certificate1=new Certificate();
        certificate1.setCourse("Python");
        certificate1.setDuration("3 Months");
        student2.setCertificate(certificate1);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(student1);
        session.update(student2);

        transaction.commit();
        session.close();

        factory.close();

    }
}
