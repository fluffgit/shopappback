package com.example.shopapp.dao;

import com.example.shopapp.entity.EndPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface EndPlaceRepository extends JpaRepository<EndPlace, Long> {
}
