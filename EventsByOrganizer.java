package com.example.qvent.controller;

import com.example.qvent.model.AddEventDetails;
import com.example.qvent.model.UserPrincipal;
import com.example.qvent.model.Users;
import com.example.qvent.repo.AddEventRepo;
import com.example.qvent.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/organizer")
public class EventsByOrganizer
{
    @Autowired
    private UserRepo repo;

    @Autowired
    private AddEventRepo eventRepo;

    @GetMapping("/my-events")
    public String getMyEvents(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();

        Users user = repo.findByEmail(userDetails.getEmail());

        List<AddEventDetails> details = eventRepo.findByOrganizer(user);

        model.addAttribute("events", details);

        return "myEvents";
    }
}
