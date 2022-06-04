package com.example.shopapp.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
    @OneToOne
    @JoinColumn(name="startPlaceDto")
    private Place startPlaceDto;
    @OneToOne
    @JoinColumn(name="endPlaceDto")
    private Place endPlaceDto;
    @Column(name="date_start")
    private Date dateStart;
    @Column(name="last_end")
    private Date lastEnd;
    @Column(name="days")
    private int days;
    @Column(name="travel_type")
    private TravelType travelType;
    @Column(name="unit_price_child")
    private BigDecimal unitPriceChild;
    @Column(name="unit_price_person")
    private BigDecimal unitPricePerson;
    @Column(name="special_offer")
    private boolean specialOffer;
    @Column(name="prize_for-child")
    private double prizeForChild;
    @Column(name="prize_for-person")
    private double prizeForPerson;
    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

}
