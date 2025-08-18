package com.wipro.empms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String region;

    public Address() {}

    public Address(String city, String region) {
        this.city = city;
        this.region = region;
    }

    public Address(Long id, String city, String region) {
        this.id = id;
        this.city = city;
        this.region = region;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

   
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
