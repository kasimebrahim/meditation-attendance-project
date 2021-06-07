package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Faculty extends Person {
	
	@Column(name="title", columnDefinition = "nvarchar(50)")
	private String title;

	@ToString.Exclude
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CourseOffering> offering = new ArrayList<>();

	public Faculty(String firstName, String lastName, String emailAddress, String title) {
		super(firstName, lastName, emailAddress);
		this.title = title;
	}

	void addOffering(CourseOffering offering) {
		this.offering.add(offering);
	}
}
