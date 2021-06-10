package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class User extends Person {
    @Column(name="title", columnDefinition = "nvarchar(50)")
    private String title;

    public User(String username, String passwordHash, String firstName, String lastName, String emailAddress, String title) {
        super(username, passwordHash, firstName, lastName, emailAddress);
        this.title = title;
    }
}
