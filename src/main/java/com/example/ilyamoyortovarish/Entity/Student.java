package com.example.ilyamoyortovarish.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@Data
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private int studentId;

    @Column
    private String name;
    @Column
    private String date;

    @ManyToOne // много студентов в одной группе поэтому мени то ван
    @JoinColumn(name = "group_id")
    private Group group;
}
