package com.example.shopapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name="country")
@Data
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_country")
    private String name;

    @Column(name="name_continent")
    @Enumerated(EnumType.STRING)
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

}
