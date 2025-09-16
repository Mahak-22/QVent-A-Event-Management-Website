package com.example.qvent.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
public class RoleHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        System.out.println("Authorities : "+ authentication.getAuthorities());

        if(role.equals("ROLE_USER"))
        {
            System.out.println("user page");
            response.sendRedirect("/user/Dashboard");
        }
        else if(role.equals("ROLE_ADMIN"))
        {
            System.out.println("admin");
            response.sendRedirect("/admin/Dashboard");
        }
        else if(role.equals("ROLE_ORGANIZER"))
        {
            System.out.println("organizer");
            response.sendRedirect("/organizer/Dashboard");
        }
        else
        {
            System.out.println("role does not exists");
        }
    }
}
