package edu.ea.project.team8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
	@Id
	private Integer id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private ClassSession classSession;

	@OneToOne
	private BarCodeRecord barCodeRecord;

	private boolean present=true;

	public Attendance(Student student, ClassSession classSession, BarCodeRecord barCodeRecord) {
		this.student = student;
		this.classSession = classSession;
		this.barCodeRecord = barCodeRecord;
	}

	public Attendance(Student student, ClassSession classSession) {
		this.student = student;
		this.classSession = classSession;
	}

	public Attendance(Student student, ClassSession classSession, boolean present) {
		this.student = student;
		this.classSession = classSession;
		this.present = present;
	}
}
