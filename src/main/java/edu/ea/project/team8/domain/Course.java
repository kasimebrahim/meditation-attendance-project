package edu.ea.project.team8.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Course {
	@Id
	@GeneratedValue
	private String id;

    private String code;

	@Column(length = 3)
    private String abbreviation;
    
	@Column(length = 255)
    private String name;

	@Column(length = 4000)
    private String description;

}
