package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EA_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

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
    private Set<Role> roles = new HashSet<>();

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
