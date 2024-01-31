package com.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo {

    public static void main(String[] args) {


        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Employee employee1=new Employee();
        Employee employee2=new Employee();

        employee1.setEmployeeName("Rahul");
        employee2.setEmployeeName("Mahesh");

        Project project1=new Project();
        Project project2=new Project();

        project1.setProjectName("HIMS");
        project2.setProjectName("Library Management System");

        List<Employee> employeeList=new ArrayList<>();
        List<Project> projectList=new ArrayList<>();

        employeeList.add(employee1);
        employeeList.add(employee2);

        projectList.add(project1);
        projectList.add(project2);

        employee1.setProjects(projectList);
        project2.setEmployees(employeeList);


        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        
        
        transaction.commit();
        factory.close();

    }
}
