package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "datetime")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "offerid")
    private CourseOffering offering;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private Student student;

    Registration(LocalDate date, CourseOffering offering, Student student) {
        this.date = date;
        this.offering = offering;
        this.student = student;
    }
}
