package edu.ea.project.team8.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@NoArgsConstructor
@Entity
public class CourseOffering {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@Column(columnDefinition = "nvarchar(50)")
	private String period;

	@Column(nullable = false)
	private LocalDate beginDate;

	@Column(nullable = false)
	private LocalDate endDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "offerid")
	@ToString.Exclude
	@Fetch(FetchMode.SUBSELECT)
	private List<Registration> registrations = new ArrayList<>();

	@Column
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "facultyId")
	private Faculty faculty;

	@OneToMany(mappedBy="offering")
	private List<ClassSession> sessions = new ArrayList<>();

	CourseOffering(Course course, String period, LocalDate beginDate,
	               LocalDate endDate, int capacity, Faculty faculty) {
		this.course = course;
		this.period = period;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.capacity = capacity;
		this.faculty = faculty;
	}

	public Registration register(LocalDate date, Student student) {
		Registration registration = new Registration(date, this, student);
		this.registrations.add(registration);
		return registration;
	}

	public ClassSession createSession(LocalDate date, Location location) {
		ClassSession session = new ClassSession(date, this, location);
		this.sessions.add(session);
		return session;
	}
}
