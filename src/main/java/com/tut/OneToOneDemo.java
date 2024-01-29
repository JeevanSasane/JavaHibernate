package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Question question1=new Question();
        question1.setQuestionId(101L);
        question1.setQuestion("What is Java ?");

        Answer answer1=new Answer();
        answer1.setAnswerId(1L);
        answer1.setAnswer("Java is Programing Language.");
        question1.setAnswer(answer1);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(question1);
//
//        Question question2=new Question();
//        question2.setQuestion("What is Collection Framework ?");
//
//        Answer answer2=new Answer();
//        answer2.setAnswer("API to work with objects in java.");
//        question2.setAnswer(answer2);

//        session.save(question2);


        transaction.commit();
        session.close();
        factory.close();
    }
}
