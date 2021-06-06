package edu.ea.project.team8.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	private Integer id;

	private String name;

	@Column(length = 4000)
	private String description;
}
