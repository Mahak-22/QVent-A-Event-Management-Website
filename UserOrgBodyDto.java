package com.example.qvent.dto;

import com.example.qvent.model.AddOrganizingBody;
import com.example.qvent.model.Users;


public class UserOrgBodyDto
{
    private int id;
    private Users organizer;
    private AddOrganizingBody organizingBody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Users organizer) {
        this.organizer = organizer;
    }

    public AddOrganizingBody getOrganizingBody() {
        return organizingBody;
    }

    public void setOrganizingBody(AddOrganizingBody organizingBody) {
        this.organizingBody = organizingBody;
    }
}
