package edu.ea.project.team8.dto;

import edu.ea.project.team8.domain.Faculty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FacultyDTO implements Serializable {
    private String title;
    private List<CourseOfferingDTO> offering;

    public FacultyDTO(Faculty faculty) {
        this.title = faculty.getTitle();
        this.offering = faculty.getOffering().stream().map(courseOffering -> new CourseOfferingDTO(courseOffering)).collect(Collectors.toList());
    }
}
