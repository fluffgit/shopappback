package com.example.shopapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="country")
@Data
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_country")
    private String name;
}
