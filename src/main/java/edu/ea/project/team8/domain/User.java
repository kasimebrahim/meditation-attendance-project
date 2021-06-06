package edu.ea.project.team8.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "EA_User")
public class User {
	@Id
	private Integer id;

	private String name;

	@Column(name = "password_hash")
	private String passwordHash;

	/*
	* Note: This is a uni-directional relationship.
	*       what ever information <Person> needs from <User>
	*       it should be available in the token.
	* */
	@OneToOne
	@JoinColumn(name = "person_id", nullable = true)
	private Person person;

	@ManyToMany
	@JoinTable(name = "User_Role",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	private Collection<Role> roles;
}
