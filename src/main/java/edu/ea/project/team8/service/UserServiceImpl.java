package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl extends BasePersonService<User, User> implements UserService{
    @Override
    protected List<User> convertToResponseList(List<User> list) {
        return list;
    }
}
