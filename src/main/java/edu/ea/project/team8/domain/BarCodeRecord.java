package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class BarCodeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "char(13)")
    private String barcode;

    private LocalDateTime timeStamp;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public BarCodeRecord(String barcode, LocalDateTime timeStamp, Location location, Student student) {
        this.barcode = barcode;
        this.timeStamp = timeStamp;
        this.location = location;
        this.student = student;
    }
}
