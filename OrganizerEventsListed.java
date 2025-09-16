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
public class OrganizerEventsListed
{
    @Autowired
    private UserRepo repo;

    @Autowired
    private AddEventRepo eventRepo;

    @GetMapping("/Home")
    public String listAllEvents(Model model)
    {
        Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userDetails = (UserPrincipal) authUser.getPrincipal();
        String userEmail = userDetails.getEmail();
        Users user = repo.findByEmail(userEmail);

        List<AddEventDetails> event = eventRepo.findByOrganizerIdNot(user.getId());

        model.addAttribute("event",event);

        return "organizerHomePage";
    }
}
