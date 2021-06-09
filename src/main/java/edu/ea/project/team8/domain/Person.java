package edu.ea.project.team8.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "lastname", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Transient
    private String fullName;

    @Column(name = "emailaddress", columnDefinition = "nvarchar(50)")
    private String emailAddress;

    private String username;

    @JsonIgnore
    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Person_Role",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    public Person(String username, String passwordHash, String firstName, String lastName, String emailAddress) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
