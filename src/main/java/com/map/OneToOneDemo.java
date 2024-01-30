package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToOneDemo {

    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Question question=new Question();
        question.setQuestion("What is java..?");

        Answer answer=new Answer();
        answer.setAnswer("Java is a Programming language.");
        answer.setQuestion(question);

        Answer answer1=new Answer();
        answer1.setAnswer("With help of java we can create softwares.");
        answer1.setQuestion(question);

        Answer answer2=new Answer();
        answer2.setAnswer("Java has different type of Frameworks.");
        answer2.setQuestion(question);

        List<Answer> answers=new ArrayList<Answer>();
        answers.add(answer);
        answers.add(answer1);
        answers.add(answer2);
        question.setAnswers(answers);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        
        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);

        transaction.commit();


        Question question1=(Question) session.get(Question.class,1);
        System.out.println(question1.getQuestion());

        for (Answer answer3: question1.getAnswers()){
            System.out.println(answer3.getAnswer());
        }

        factory.close();
    }
}
