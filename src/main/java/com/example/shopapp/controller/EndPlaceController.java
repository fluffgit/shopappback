package com.example.shopapp.controller;

import com.example.shopapp.dto.*;
import com.example.shopapp.entity.Place;
import com.example.shopapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endPlace")
public class EndPlaceController {

    @Autowired
    private PlaceService endPlaceService;

    @GetMapping("")
    public List<EndPlaceDto> getAll(){
        return endPlaceService.findAll().stream().map(place -> EndPlaceDto.builder()
                .id(place.getId()).citiesDto(place.getCities().stream()
                        .map(city -> CityDto.builder().id(city.getId()).name(city.getName()).build()
                        ).collect(Collectors.toList())).hotelsDto(place.getHotels().stream()
                        .map(hotel -> HotelDto.builder().id(hotel.getId()).name(hotel.getName()).build()
                        ).collect(Collectors.toList())).airportsDto(place.getAirports().stream()
                        .map(airport -> AirportDto.builder().id(airport.getId()).name(airport.getName()).build()
                        ).collect(Collectors.toList())).build()).collect(Collectors.toList()); }

    @GetMapping("/{id}")
    public List<EndPlaceDto> getById(@PathVariable("id") long id){
        return endPlaceService.getReferenceById(id).stream().map(place -> EndPlaceDto.builder()
                .id(place.getId()).citiesDto(place.getCities().stream()
                        .map(city -> CityDto.builder().id(city.getId()).name(city.getName()).build()
                        ).collect(Collectors.toList())).hotelsDto(place.getHotels().stream()
                        .map(hotel -> HotelDto.builder().id(hotel.getId()).name(hotel.getName()).build()
                        ).collect(Collectors.toList())).airportsDto(place.getAirports().stream()
                        .map(airport -> AirportDto.builder().id(airport.getId()).name(airport.getName()).build()
                        ).collect(Collectors.toList())).build()).collect(Collectors.toList()); }

    @PostMapping("/{id}/continent")
    public Place add(@PathVariable("id") long id, @RequestBody EndPlaceDto endplaceDto){
        return endPlaceService.save(Place.builder().id(null).build());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody EndPlaceDto endplaceDto){
        endPlaceService.save(Place.builder().id(id).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        endPlaceService.delete(id);
    }
}
