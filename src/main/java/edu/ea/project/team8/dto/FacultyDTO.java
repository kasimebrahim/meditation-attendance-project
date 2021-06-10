package edu.ea.project.team8.dto;

import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FacultyDTO extends Person implements Serializable {

    private String title;
    private String fullName;
    private List<CourseOfferingDTO> offering;

    public FacultyDTO(Faculty faculty) {
        this.setId(faculty.getId());
        this.setFirstName(faculty.getFirstName());
        this.setLastName(faculty.getLastName());
        this.setFullName(faculty.getFullName());
        this.setEmailAddress(faculty.getEmailAddress());
        this.setUsername(faculty.getUsername());
        this.setRoles(faculty.getRoles());
        this.title = faculty.getTitle();
        this.offering = faculty.getOffering().stream().map(courseOffering -> new CourseOfferingDTO(courseOffering)).collect(Collectors.toList());
    }
}
