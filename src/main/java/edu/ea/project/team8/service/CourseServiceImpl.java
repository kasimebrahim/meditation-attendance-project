package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl extends BaseServiceImpl<Course, Course, Integer> {

    @Override
    protected List<Course> convertToResponseList(List<Course> list) {
        return list;
    }
}
