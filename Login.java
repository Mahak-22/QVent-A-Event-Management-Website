package com.example.qvent.controller;

import com.example.qvent.dto.UserDto;
import com.example.qvent.model.Users;
import com.example.qvent.repo.UserRepo;
import com.example.qvent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login
{
    @Autowired
    private UserService service;

    @Autowired
    private UserRepo repo;

    @GetMapping("/login")
    public String userLogin(Model model)
    {
        model.addAttribute("dto",new UserDto());
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        UserDto userDto = new UserDto();
        model.addAttribute("dto", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("dto") UserDto userDto, Model model)
    {
        String encodedPassword = service.registerUser(userDto.getPassword());

        Users dto = new Users();
        dto.setUsername(userDto.getUsername());
        dto.setEmail(userDto.getEmail());
        dto.setPassword(encodedPassword);
        dto.setRole(userDto.getRole());
        dto.setContact(userDto.getContact());
        dto.setAddress(userDto.getAddress());

        repo.save(dto);

        model.addAttribute("dto", new UserDto());
        return "login";
    }

    @GetMapping("/logout")
    public String userLogout()
    {
        return "redirect:/login";
    }
}