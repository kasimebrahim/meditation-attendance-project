package edu.ea.project.team8.config.security;

import edu.ea.project.team8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    @Autowired
    private PersonService personService;

    public CustomUserDetails getAuthUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) personService.loadUserByUsername(user.getUsername());
        return userDetails;
    }
}
