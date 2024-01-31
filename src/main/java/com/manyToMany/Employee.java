package com.manyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String employeeName;


    @ManyToMany
    @JoinTable
    (
    	name="emp_project_mapping",
    	joinColumns = {@JoinColumn(name="empId")},
    	inverseJoinColumns = {@JoinColumn(name="projectId")}
    )
    private List<Project> projects;

    public Employee() {
        super();
    }

    public Employee(int empId, String employeeName, List<Project> projects) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.projects = projects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
