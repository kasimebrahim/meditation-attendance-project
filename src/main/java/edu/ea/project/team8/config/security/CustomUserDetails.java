package edu.ea.project.team8.config.security;

import edu.ea.project.team8.domain.Person;
import edu.ea.project.team8.domain.Role;
import edu.ea.project.team8.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final Person person;
    private final Collection<Role> roles;

    public CustomUserDetails(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPasswordHash();
        roles = user.getRoles();
        person = user.getPerson();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
