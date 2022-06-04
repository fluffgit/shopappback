package com.example.shopapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name_country")
    private String name;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private Continent continent;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

}
