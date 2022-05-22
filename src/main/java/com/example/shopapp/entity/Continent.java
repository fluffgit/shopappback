package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="continent")
@Data
public class Continent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_continent")
    private String name;
}
