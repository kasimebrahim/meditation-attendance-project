package edu.ea.project.team8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private ClassSession classSession;

    @OneToOne
    private BarCodeRecord barCodeRecord;

    @Transient
    private String courseName;

    private Boolean present = true;

    public Attendance(Student student, ClassSession classSession, BarCodeRecord barCodeRecord) {
        this.student = student;
        this.classSession = classSession;
        this.barCodeRecord = barCodeRecord;
    }

    public Attendance(Student student, ClassSession classSession) {
        this.student = student;
        this.classSession = classSession;
    }

    public Attendance(Student student, ClassSession classSession, Boolean present) {
        this(student, classSession);
        this.present = present;
    }

    public Attendance(Student student, ClassSession classSession, Boolean present, Integer id) {
        this(student, classSession, present);
        this.id = id;
    }

    public boolean isPresent() {
        return present;
    }

    public String getCourseName() {
        if (classSession != null && classSession.getOffering() != null)
            return classSession.getOffering().getCourse().getName();
        else
            return "";
    }
}
