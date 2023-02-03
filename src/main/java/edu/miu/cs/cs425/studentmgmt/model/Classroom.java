package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

    private String buildingName;

    private String roomNumber;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)*/
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

}
