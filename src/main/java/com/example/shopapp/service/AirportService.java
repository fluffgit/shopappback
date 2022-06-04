package com.example.shopapp.service;

import com.example.shopapp.dao.AirportRepository;
import com.example.shopapp.entity.Airport;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> findAll() { return airportRepository.findAll(); }

    public List<Airport> getReferenceById(Long id) {
        return airportRepository.findById(id).stream().collect(Collectors.toList());
    }

    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport delete(Long id) { airportRepository.deleteById(id);
        return null;
    }
}
