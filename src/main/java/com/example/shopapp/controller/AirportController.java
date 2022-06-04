package com.example.shopapp.controller;

import com.example.shopapp.dto.AirportDto;
import com.example.shopapp.entity.Airport;
import com.example.shopapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("")
    public List<Airport> getAll(){
        return airportService.findAll(); }

    @GetMapping("/{id}")
    public List<Airport> getById(@PathVariable("id") long id){
        return airportService.getReferenceById(id); }

    @PostMapping("")
    public Airport add(@RequestBody Airport newAirport){
        return airportService.save(Airport.builder().id(null).name(newAirport.getName()).build());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Airport airport){
        airportService.save(Airport.builder().id(id).name(airport.getName()).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        airportService.delete(id);
    }
}
