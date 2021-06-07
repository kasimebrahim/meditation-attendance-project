package edu.ea.project.team8.domain;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "datetime")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="offerid")
	private CourseOffering offering;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;

	Registration(LocalDate date, CourseOffering offering, Student student) {
		this.date = date;
		this.offering = offering;
		this.student = student;
	}
}
