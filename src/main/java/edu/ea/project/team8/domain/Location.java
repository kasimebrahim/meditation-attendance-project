package edu.ea.project.team8.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String building;

    @Column(nullable = false)
    private Integer capacity;

    public Location(String name, String building, Integer capacity) {
        this.name = name;
        this.building = building;
        this.capacity = capacity;
    }

    //    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<BarCodeRecord> barcodes = new ArrayList<>();
//
//    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<CourseOffering> offerings = new ArrayList<>();
}
