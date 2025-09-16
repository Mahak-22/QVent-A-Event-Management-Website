package com.example.qvent.dto;

import com.example.qvent.model.AddOrganizingBody;
import com.example.qvent.model.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddEventDto
{
    private int id;

    private String eventName;
    private String eventType;
    private String ageLimit;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venue;
    private double ticketPrice;
    private double earlyBirdPrice;
    private LocalDate regDeadline;
    private String mode;
    private String description;
    private String poster;

    private Users organizer;

    private AddOrganizingBody organizingBody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventTye(String eventTye) {
        this.eventType = eventTye;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getEarlyBirdPrice() {
        return earlyBirdPrice;
    }

    public void setEarlyBirdPrice(double earlyBirdPrice) {
        this.earlyBirdPrice = earlyBirdPrice;
    }

    public LocalDate getRegDeadline() {
        return regDeadline;
    }

    public void setRegDeadline(LocalDate regDeadline) {
        this.regDeadline = regDeadline;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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
