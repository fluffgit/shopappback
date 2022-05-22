package com.example.shopapp.controller;

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
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable("id") long id){
        return (City) cityService.getReferenceById(id);
    }

    @GetMapping("/{name_city}")
    public City getByName(@PathVariable("name_city") String name_city){
        return (City) cityService.getReferenceByName(name_city);
    }

    @PostMapping("")
    public int add(@RequestBody List<City> cities){
        return cityService.save(cities);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody City updatedCity){
        City city = (City) cityService.getReferenceById(id);

        if(city != null) {
            city.setName(updatedCity.getName());
            city.setCountry(updatedCity.getCountry());
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") long id, @RequestBody City updatedCity){
        City city = (City) cityService.getReferenceById(id);

        if(city != null) {
            if (updatedCity.getName() != null) city.setName(updatedCity.getName());
            if (updatedCity.getCountry() != null) city.setCountry(updatedCity.getCountry());

            cityService.update(city);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return cityService.delete(id);
    }
}
