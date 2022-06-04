package com.example.shopapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="place")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Place {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<City> cities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Hotel> hotels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Airport> airports;
}
