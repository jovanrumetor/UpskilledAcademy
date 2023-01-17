package com.alterra.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjectS")
public class Subject {

    @Id
    private int id;
    private String userName;
    private String subjectName;
    private String subjectDay;
//
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;
//
//
//    public Subject(int id, String subjectName, String day) {
//        super();
//        this.id = id;
//        this.subjectName = subjectName;
//        this.day = day;
//    }
}
