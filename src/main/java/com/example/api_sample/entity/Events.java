package com.example.api_sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private String eventName;
    private String venue;
    private String eventDate;
    private String eventStatus;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Events(long id, long userId, String eventName, String venue, String eventDate, String eventStatus,
            long price) {
        super();
        this.id = id;
        this.userId = userId;
        this.eventName = eventName;
        this.venue = venue;
        this.eventDate = eventDate;
        this.eventStatus = eventStatus;
        this.price = price;
    }

    public Events() {
        super();
    }

    @Override
    public String toString() {
        return "Events [getId()=" + getId() + ", getUserId()=" + getUserId() + ", getEventName()=" + getEventName()
                + ", getVenue()=" + getVenue() + ", getEventDate()=" + getEventDate() + ", getEventStatus()="
                + getEventStatus() + ", getPrice()=" + getPrice() + "]";
    }

}
