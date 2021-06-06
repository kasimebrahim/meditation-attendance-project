package edu.ea.project.team8.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(length = 4000)
	private String description;
}
