package com.example.qvent.controller;

import com.example.qvent.dto.AddEventDto;
import com.example.qvent.model.AddOrganizingBody;
import com.example.qvent.model.UserPrincipal;
import com.example.qvent.model.Users;
import com.example.qvent.repo.AddEventRepo;
import com.example.qvent.repo.OrganizerBodyRepo;
import com.example.qvent.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/organizer")
public class AddEventDetails
{
    @Autowired
    private AddEventRepo eventRepo;

    @Autowired
    private OrganizerBodyRepo bodyRepo;

    @Autowired
    private UserRepo repo;

    @GetMapping("/addEvent")
    public String addEvent(@RequestParam("orgBodyId") int orgBodyId, Model model)
    {
        AddEventDto dto = new AddEventDto();
        AddOrganizingBody body = bodyRepo.findById(orgBodyId).orElseThrow(() -> new RuntimeException("Organizing Body not found"));
        dto.setOrganizingBody(body);
        model.addAttribute("dto",dto);
        return "EventDetails";
    }

    @PostMapping("/addEvent")
    public String addEventDetails(@ModelAttribute("dto") AddEventDto eventDto,
                                  @RequestParam("eventImage")MultipartFile file, Model model) throws IOException
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();

        String email = userDetails.getEmail();

        Users user = repo.findByEmail(email);

        AddOrganizingBody addBody = bodyRepo.findById(eventDto.getOrganizingBody().getId()).orElseThrow(() -> new RuntimeException("organizing body Id not found"));

        if(user!=null)
        {
            com.example.qvent.model.AddEventDetails eventDetails = new com.example.qvent.model.AddEventDetails();
            eventDetails.setEventName(eventDto.getEventName());
            eventDetails.setEventType(eventDto.getEventType());
            eventDetails.setAgeLimit(eventDto.getAgeLimit());
            eventDetails.setStartDate(eventDto.getStartDate());
            eventDetails.setEndDate(eventDto.getEndDate());
            eventDetails.setStartTime(eventDto.getStartTime());
            eventDetails.setEndTime(eventDto.getEndTime());
            eventDetails.setVenue(eventDto.getVenue());
            eventDetails.setTicketPrice(eventDto.getTicketPrice());
            eventDetails.setDescription(eventDto.getDescription());
            eventDetails.setMode(eventDto.getMode());
            eventDetails.setEarlyBirdPrice(eventDto.getEarlyBirdPrice());
            eventDetails.setRegDeadline(eventDto.getRegDeadline());
            eventDetails.setOrganizingBody(addBody);
            eventDetails.setOrganizer(user);

            if(!file.isEmpty())
            {
                String uploadDir = "/uploads/";
                Path uploadPath = Paths.get(uploadDir);
                if(!Files.exists(uploadPath))
                {
                    Files.createDirectories(uploadPath);
                }

                String fileName = file.getOriginalFilename();
                assert fileName != null;
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                eventDetails.setPoster(fileName);
            }
            com.example.qvent.model.AddEventDetails event = eventRepo.save(eventDetails);
            model.addAttribute("event",event);
        }
        return "eventAddedPage";
    }
}