package com.example.shopapp.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="product")
@Data
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="startplace_id")
    private StartPlace startPlace;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="endplace_id")
    private EndPlace endPlace;
    @Column(name="date_start")
    private Date dateStart;
    @Column(name="date_end")
    private Date lastEnd;
    @Column(name="days")
    private int days;
    @Column(name="travel_type")
    @Enumerated(EnumType.STRING)
    private TravelType travelTypes;
    @Column(name="unit_child")
    private int unitChild;
    @Column(name="unit_person")
    private int unitPerson;
    @Column(name="special_offer")
    private boolean specialOffer;
    @Column(name="price_for_child")
    private BigDecimal priceForChild;
    @Column(name="price_for_person")
    private BigDecimal priceForPerson;
    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

}
