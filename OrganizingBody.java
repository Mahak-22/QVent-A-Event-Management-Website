package com.example.qvent.controller;

import com.example.qvent.dto.AddOrganizingBodyDto;
import com.example.qvent.model.AddOrganizingBody;
import com.example.qvent.repo.OrganizerBodyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/organizer")
public class OrganizingBody
{
    @Autowired
    private OrganizerBodyRepo bodyRepo;

    @GetMapping("/addOrganizingBody")
    public String addBody(Model model)
    {
        AddOrganizingBodyDto dto = new AddOrganizingBodyDto();
        model.addAttribute("dto",dto);
        return "organizingBodyDetails";
    }

    @PostMapping("/addOrganizingBody")
    public String addOrganizerBody(@ModelAttribute("dto") AddOrganizingBodyDto bodyDto, Model model, RedirectAttributes redirectAttributes)
    {
        AddOrganizingBody dto = new AddOrganizingBody();

        dto.setName(bodyDto.getName());
        dto.setEmail(bodyDto.getEmail());
        dto.setAddress(bodyDto.getAddress());
        dto.setContact(bodyDto.getContact());

        bodyRepo.save(dto);
        redirectAttributes.addAttribute("orgBodyId",dto.getId());
        model.addAttribute("dto", new AddOrganizingBodyDto());
        return "redirect:/organizer/addEvent";
    }
}
