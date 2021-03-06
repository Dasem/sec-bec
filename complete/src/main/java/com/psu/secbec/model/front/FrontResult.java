package com.psu.secbec.model.front;

import com.psu.secbec.db.*;
import com.psu.secbec.model.result.*;

import java.util.*;
import java.util.stream.*;

public class FrontResult {
    private String username;
    private List<Event> events;

    public TestResult convert(MistakeCrud mistakeCrud) {
        TestResult testResult = new TestResult();
        testResult.setUsername(username);
        testResult.setTestDate(new Date());
        testResult.setMistakes(events.stream().distinct().map(event ->
                mistakeCrud.findByName(event.getName()))
                .collect(Collectors.toList()));
        int mistakesCost = testResult.getMistakes().stream().map(Mistake::getCost).reduce(Integer::sum).orElse(0);
        testResult.setTotalPoints(100 - mistakesCost);
        return testResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
