package com.example.shopapp.controller;

import com.example.shopapp.entity.Airport;
import com.example.shopapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("")
    public List<Airport> getAll(){
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public Airport getById(@PathVariable("id") long id){
        return (Airport) airportService.getReferenceById(id);
    }

    @GetMapping("/{name_airport}")
    public Airport getByName(@PathVariable("name_airport") String name_aiport){
        return (Airport) airportService.getReferenceByName(name_aiport);
    }

    @PostMapping("")
    public int add(@RequestBody List<Airport> airports){
        return airportService.save(airports);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Airport updatedAirport){
        Airport airport = (Airport) airportService.getReferenceById(id);

        if(airport != null) {
            airport.setName(updatedAirport.getName());
            airport.setCity(updatedAirport.getCity());
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") long id, @RequestBody Airport updatedairport){
        Airport airport = (Airport) airportService.getReferenceById(id);

        if(airport != null) {
            if (updatedairport.getName() != null) airport.setName(updatedairport.getName());
            if (updatedairport.getCity() != null) airport.setCity(updatedairport.getCity());

            airportService.update(airport);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return airportService.delete(id);
    }
}
