package com.example.shopapp.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="airport")
@Data
public class Hotel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_hotel")
    private String name;
    @OneToOne
    @JoinColumn(name="city_id")
    private City city;
}
