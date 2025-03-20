package com.shree.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "address_id", referencedColumnName = "id")
    // @JsonBackReference
    // private Address address;
    @OneToMany(cascade=CascadeType.ALL)
    @JsonManagedReference
    List<Address> address=new ArrayList<>();

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Address> getAddress() {
        return address;
    }


    public void setAddress(List<Address> address) {
        this.address = address;
    }
    
    

    public User(Long id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public User() {
    }


   
    


}
