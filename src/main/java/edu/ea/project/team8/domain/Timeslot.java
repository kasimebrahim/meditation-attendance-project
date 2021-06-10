package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Timeslot")
public class Timeslot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    public Timeslot(String code, String title, LocalTime startTime, LocalTime endTime) {
        this.code = code;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
