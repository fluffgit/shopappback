package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="airport")
@Data
public class Airport {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_airport")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="name_city", referencedColumnName = "id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<EndPlace> endPlaces;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<StartPlace> startPlaces;
}
