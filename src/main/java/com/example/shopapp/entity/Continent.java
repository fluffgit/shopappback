package com.example.shopapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="continent")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Continent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_continent")
    private String name;
    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

}
