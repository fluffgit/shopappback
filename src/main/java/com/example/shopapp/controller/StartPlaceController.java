package com.example.shopapp.controller;

import com.example.shopapp.dto.*;
import com.example.shopapp.entity.Place;
import com.example.shopapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/startPlace")
public class StartPlaceController {

    @Autowired
    private PlaceService startPlaceService;

    @GetMapping("")
    public List<StartPlaceDto> getAll(){
        return startPlaceService.findAll().stream().map(place -> StartPlaceDto.builder()
                .id(place.getId()).citiesDto(place.getCities().stream()
                        .map(city -> CityDto.builder().id(city.getId()).name(city.getName()).build()
                        ).collect(Collectors.toList())).airportsDto(place.getAirports().stream()
                        .map(airport -> AirportDto.builder().id(airport.getId()).name(airport.getName()).build()
                        ).collect(Collectors.toList())).build()).collect(Collectors.toList()); }

    @GetMapping("/{id}")
    public List<StartPlaceDto> getById(@PathVariable("id") long id){
        return startPlaceService.getReferenceById(id).stream().map(place -> StartPlaceDto.builder()
                .id(place.getId()).citiesDto(place.getCities().stream()
                        .map(city -> CityDto.builder().id(city.getId()).name(city.getName()).build()
                        ).collect(Collectors.toList())).airportsDto(place.getAirports().stream()
                        .map(airport -> AirportDto.builder().id(airport.getId()).name(airport.getName()).build()
                        ).collect(Collectors.toList())).build()).collect(Collectors.toList()); }

    @PostMapping("/{id}/continent")
    public Place add(@PathVariable("id") long id, @RequestBody StartPlaceDto startplaceDto){
        return startPlaceService.save(Place.builder().id(null).build());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody StartPlaceDto startplaceDto){
        startPlaceService.save(Place.builder().id(id).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        startPlaceService.delete(id);
    }
}
