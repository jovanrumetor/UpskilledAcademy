package com.alterra.task.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {
    @Id
    private int id;
    private String name;
    private String topic;
//    @OneToMany(mappedBy = "users")
//    private List<Subject> subject;

}
