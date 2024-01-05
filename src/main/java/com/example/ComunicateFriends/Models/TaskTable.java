package com.example.ComunicateFriends.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title,namedCompany,fullText,deadline;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public TaskTable() {
    }

    public TaskTable(String title, String namedCompany, String fullText, String deadline) {
        this.title = title;
        this.namedCompany = namedCompany;
        this.fullText = fullText;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamedCompany() {
        return namedCompany;
    }

    public void setNamedCompany(String namedCompany) {
        this.namedCompany = namedCompany;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

}
