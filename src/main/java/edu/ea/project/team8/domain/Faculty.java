package edu.ea.project.team8.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	@OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CourseOffering> offering = new ArrayList<>();

	public Faculty(String username, String password, String firstName, String lastName, String emailAddress, String title) {
		super(username, password, firstName, lastName, emailAddress);
		this.title = title;
	}

	void addOffering(CourseOffering offering) {
		this.offering.add(offering);
	}
}
