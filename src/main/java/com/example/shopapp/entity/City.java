package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="city")
@Data
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_city")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_country", referencedColumnName = "id")
    private Country country;

    @OneToOne(mappedBy = "city")
    private Airport airport;

    @OneToMany(mappedBy = "city")
    private Set<Hotel> hotels;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<EndPlace> endPlaces;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<StartPlace> startPlaces;
}
