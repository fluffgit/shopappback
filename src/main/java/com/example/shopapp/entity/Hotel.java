package com.example.shopapp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="hotel")
@Data
public class Hotel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name="name_hotel")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_city", referencedColumnName = "id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<EndPlace> endPlaces;
}
