package com.example.qvent.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizer")
public class OrganizerDashboard
{
    @GetMapping("/Dashboard")
    public String dashboardPage()
    {
        return "organizerDashboard";
    }
}
