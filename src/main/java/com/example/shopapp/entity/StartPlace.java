package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="startplace")
@Data
public class StartPlace {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_city", referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_airport", referencedColumnName = "id")
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startPlace")
    private Set<Product> startList;
}