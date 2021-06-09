package edu.ea.project.team8.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ClassSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	private Timeslot timeslot;

	@Column(nullable=false)
    private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "offerId")
	private CourseOffering offering;

	@ManyToOne(cascade = CascadeType.MERGE)
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
}
