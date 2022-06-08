package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="endplace")
@Data
public class EndPlace {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_city", referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_hotel", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name_airport", referencedColumnName = "id")
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endPlace")
    private Set<Product> endList;
}
