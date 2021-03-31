package com.psu.secbec.model.result;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "test_result")
public class TestResult {


    private Integer id;
    private String username;
    private Date testDate;
    private int totalPoints;
    private List<Mistake> mistakes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "mistakes_in_test",
            joinColumns = @JoinColumn(name = "test_result_id"),
            inverseJoinColumns = @JoinColumn(name = "mistake_id"))
    public List<Mistake> getMistakes() {
        return mistakes;
    }

    public void setMistakes(List<Mistake> mistakes) {
        this.mistakes = mistakes;
    }
}
