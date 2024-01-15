package com.example.ComunicateFriends.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Data
@NoArgsConstructor
@Entity
public class TaskTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String title,namedCompany,fullText,deadline;

    public TaskTable(String title, String namedCompany, String fullText, String deadline) {
        this.title = title;
        this.namedCompany = namedCompany;
        this.fullText = fullText;
        this.deadline = deadline;
    }
}