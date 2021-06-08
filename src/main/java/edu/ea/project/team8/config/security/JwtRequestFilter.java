package edu.ea.project.team8.config.security;


import edu.ea.project.team8.config.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain)
            throws ServletException, IOException {
        try {

            String jwtToken = extractJwtFromRequest(request);

            if (StringUtils.hasText(jwtToken) && jwtTokenUtil.validateToken(jwtToken)) {
                UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken), "",
                        jwtTokenUtil.getRolesFromToken(jwtToken));

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            } else {
                logger.error("Cannot set the Security Context");
            }

        } catch (ExpiredJwtException ex) {
            request.setAttribute("exception", ex);
        } catch (BadCredentialsException ex) {
            request.setAttribute("exception", ex);
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
    }


    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
