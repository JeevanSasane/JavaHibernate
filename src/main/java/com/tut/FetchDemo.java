package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Student student=(Student) session.get(Student.class, 7);
        System.out.println(student);

        Address address=(Address) session.get(Address.class,2);
        System.out.println(address.getCity());
        session.close();
    }
}
