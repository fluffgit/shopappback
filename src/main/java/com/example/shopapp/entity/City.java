package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="city")
@Data
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_city")
    private String name;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
