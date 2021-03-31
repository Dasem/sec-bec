package com.psu.secbec.model.front;

public class Event {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return ((Event) obj).name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode();
    }
}
