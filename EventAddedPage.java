package com.example.qvent.controller;

import com.example.qvent.model.AddEventDetails;
import com.example.qvent.model.UserPrincipal;
import com.example.qvent.model.Users;
import com.example.qvent.repo.AddEventRepo;
import com.example.qvent.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizer")
public class EventAddedPage
{
    @Autowired
    private AddEventRepo eventRepo;

    @Autowired
    private UserRepo repo;

    @GetMapping("/eventDetails/{id}")
    public String eventDetails(@PathVariable int id, Model model)
    {
        AddEventDetails event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        String email = userDetails.getEmail();
        Users user =  repo.findByEmail(email);

        model.addAttribute("event", event);
        model.addAttribute("user",user);
        return "eventAddedPage";
    }
}
