package edu.ea.project.team8.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty extends Person {
	
	@Column(name="title", columnDefinition = "nvarchar(50)")
	private String title;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CourseOffering> offering = new ArrayList<>();

}
