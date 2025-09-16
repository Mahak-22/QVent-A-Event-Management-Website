package com.example.qvent.controller;

import com.example.qvent.dto.UserDto;
import com.example.qvent.model.UserPrincipal;
import com.example.qvent.model.Users;
import com.example.qvent.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizer")
public class OrganizerProfile
{

    @Autowired
    private UserRepo repo;

    @GetMapping("/profile")
    public String getProfile(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

        String email = userPrincipal.getEmail();

        Users user = repo.findByEmail(email);

        if(user!=null)
        {
            UserDto dto = new UserDto();
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());
            dto.setContact(user.getContact());
            dto.setAddress(user.getAddress());

            model.addAttribute("dto",dto);
        }
        return "organizerProfile";
    }

    @GetMapping("/update-profile")
    public String getData(Model model)
    {
        Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authUser.getPrincipal();

        String emailAdd = userPrincipal.getEmail();
        Users user = repo.findByEmail(emailAdd);

        if(user!=null)
        {
            UserDto userDto = new UserDto();

            userDto.setUsername(user.getUsername());
            userDto.setEmail(user.getEmail());
            userDto.setContact(user.getContact());
            userDto.setRole(user.getRole());
            userDto.setAddress(user.getAddress());

            model.addAttribute("userDto", userDto);

        }
        return "organizerUpdateProfile";
    }

    @PostMapping("/update-profile")
    public String updateData(@ModelAttribute("userDto") UserDto userDto)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userDetails = (UserPrincipal) auth.getPrincipal();
        String userEmail = userDetails.getEmail();
        Users user = repo.findByEmail(userEmail);

        if(user!=null)
        {
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setContact(userDto.getContact());
            user.setAddress(userDto.getAddress());
            user.setRole(userDto.getRole());

            repo.save(user);
        }
        return "redirect:/organizer/profile";
    }
}
