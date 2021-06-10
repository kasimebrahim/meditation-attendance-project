package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(length = 3)
    private String abbreviation;

    @Column(length = 255)
    private String name;

    @Column(length = 4000)
    private String description;

    public Course(String code, String abbreviation, String name, String description) {
        this.code = code;
        this.abbreviation = abbreviation;
        this.name = name;
        this.description = description;
    }

    public CourseOffering createOffering(String period, LocalDate beginDate,
                                         LocalDate endDate, int capacity,
                                         Faculty faculty) {
        CourseOffering cof = new CourseOffering(this, period, beginDate, endDate, capacity, faculty);
        faculty.addOffering(cof);
        return cof;
    }
}
