package com.example.ilyamoyortovarish.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Data
@Setter
@Table(name = "all_groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_number")
    private String groupNumber;

    @OneToMany(mappedBy = "group")
    List<Student> students;

}
