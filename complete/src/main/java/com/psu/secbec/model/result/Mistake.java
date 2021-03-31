package com.psu.secbec.model.result;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "mistake")
public class Mistake {
    private Integer id;
    private String name;
    private String description;
    private int cost;
    private List<TestResult> testResults;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @ManyToMany(mappedBy = "mistakes", cascade = CascadeType.ALL)
    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }
}
