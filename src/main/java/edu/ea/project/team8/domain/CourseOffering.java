package edu.ea.project.team8.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.NoArgsConstructor;
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

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@Column(columnDefinition = "nvarchar(50)")
	private String period;

	@Column(nullable = false)
	private LocalDate beginDate;

	@Column(nullable = false)
	private LocalDate endDate;

	@OneToMany
	@JoinColumn(name = "offerid")
	@Fetch(FetchMode.SUBSELECT)
	private List<Registration> registrations;

	@Column
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "facultyId")
	private Faculty faculty;

	@OneToMany
	@JoinColumn(name = "sessionId")
	private List<ClassSession> sessions;

	CourseOffering(Course course, String period, LocalDate beginDate,
	               LocalDate endDate, int capacity, Faculty faculty) {
		this.course = course;
		this.period = period;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.capacity = capacity;
		this.faculty = faculty;
	}

	public void addRegistration(Registration registration) {
		this.registrations.add(registration);
	}

	public void addSession(ClassSession session) {this.sessions.add(session);}
}
