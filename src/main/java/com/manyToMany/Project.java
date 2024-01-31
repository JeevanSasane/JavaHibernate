package com.manyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project(int pId, String projectName, List<Employee> employees) {
        this.pId = pId;
        this.projectName = projectName;
        this.employees = employees;
    }

    public Project() {
        super();
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
