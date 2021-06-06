package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(length = 4000)
	private String description;

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
