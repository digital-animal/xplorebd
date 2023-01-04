package com.zahid.tour.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.zahid.auth.model.Account;
import com.zahid.place.model.Place;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter
    private String title;
    
    @Getter
    @Setter
    private String description;
    
    @Getter
    @Setter
    private String startDate;
    
    @Getter
    @Setter
    private String endDate;
    
    @Getter
    @Setter
    private Integer capacity;
    
    @Getter
    @Setter
    private Double cost;
    
    @Getter
    @Setter
    private String image;

    // one tour can have many place
    // one place can have many tour
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tour_place", 
        joinColumns = {@JoinColumn(name = "tour_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "place_id", referencedColumnName = "id")}
        )
    private Set<Place> places = new HashSet<>();


    // one tour can have many account
    // one account can have many tour
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tour_account", 
        joinColumns = {@JoinColumn(name = "tour_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")}
    )
    private Set<Account> accounts = new HashSet<>();

    public Tour() {
    }

    public Tour(String title, String description, String startDate, String endDate, Integer capacity,
            Double cost) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.cost = cost;
    }


    @Override
    public String toString() {
        return String.format("Tour(id=%s, title=%s, description=%s, startDate=%s, endDate=%s, capacity=%s, cost=%s)", id, title, description, startDate, endDate, capacity, cost);
    }
    
}
