package com.example.shopapp.controller;

import com.example.shopapp.dto.CityDto;
import com.example.shopapp.entity.City;
import com.example.shopapp.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("")
    public List<City> getAll(){
        return cityService.findAll(); }

    @GetMapping("/{id}")
    public List<City> getById(@PathVariable("id") long id){
        return cityService.getReferenceById(id); }

    @PostMapping("")
    public City add(@RequestBody City newCity){
        return cityService.save(City.builder().name(newCity.getName()).build());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody CityDto city){
        cityService.save(City.builder().id(id).name(city.getName()).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        cityService.delete(id);
    }
}
