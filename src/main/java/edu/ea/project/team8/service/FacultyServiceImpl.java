package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("facultyService")
@Transactional(propagation = Propagation.REQUIRED)
public class FacultyServiceImpl extends BasePersonService<FacultyDTO, Faculty> implements FacultyService {

    @Override
    protected List<FacultyDTO> convertToResponseList(List<Faculty> list) {
        return list.stream().map(faculty -> new FacultyDTO(faculty)).collect(Collectors.toList());
    }
}
