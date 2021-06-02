package edu.ea.project.team8.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "lastname", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "emailaddress", columnDefinition = "nvarchar(50)")
    private String emailAddress;

}
