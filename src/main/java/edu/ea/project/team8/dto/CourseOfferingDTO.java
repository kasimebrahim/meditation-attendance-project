package edu.ea.project.team8.dto;

import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.CourseOffering;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CourseOfferingDTO implements Serializable {
    private Integer id;
    private Course course;
    private String period;
    private LocalDate beginDate;
    private LocalDate endDate;
    private int capacity;
    private int registeredStudents;

    public CourseOfferingDTO(CourseOffering courseOffering) {
        this.id = courseOffering.getId();
        this.course = courseOffering.getCourse();
        this.period = courseOffering.getPeriod();
        beginDate = courseOffering.getBeginDate();
        endDate = courseOffering.getEndDate();
        capacity = courseOffering.getCapacity();
        registeredStudents = courseOffering.getRegistrations().size();
    }
}
