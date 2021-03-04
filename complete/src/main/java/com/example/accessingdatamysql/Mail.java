package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
@Table(name = "mails")
public class Mail {

    private Long id;
    private String author;
    private String theme;
    private String text;
    private String time;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Column
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
