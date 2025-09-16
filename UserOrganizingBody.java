package com.example.qvent.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "userorgbody")
public class UserOrganizingBody
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users organizer;

    @ManyToOne
    @JoinColumn(name="org_body_id" , nullable = false)
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
