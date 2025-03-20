package com.shree.springapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    
    //@OneToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address(long id, String street, String city, User user) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.user = user;
    }

    public Address() {
    }

     


}
