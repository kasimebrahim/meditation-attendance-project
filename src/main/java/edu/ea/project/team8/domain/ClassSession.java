package edu.ea.project.team8.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
public class ClassSession implements Serializable, Comparable<ClassSession> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Timeslot timeslot;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "offerId")
    @JsonBackReference
    private CourseOffering offering;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    ClassSession(LocalDate date, CourseOffering offering, Location location) {
        this.date = date;
        this.offering = offering;
        this.location = location;
    }

    ClassSession(LocalDate date, CourseOffering offering, Location location, Timeslot timeslot) {
        this.date = date;
        this.offering = offering;
        this.location = location;
        this.timeslot = timeslot;
    }

    public Timeslot addTimeslot(String code, String title, LocalTime startTime, LocalTime endTime) {
        this.timeslot = new Timeslot(code, title, startTime, endTime);
        return timeslot;
    }

    public void addTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public int compareTo(ClassSession classSession) {
        return this.date.compareTo(classSession.date);
    }
}
