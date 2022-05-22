package com.example.shopapp.controller;

import com.example.shopapp.entity.Country;
import com.example.shopapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("")
    public List<Country> getAll(){
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable("id") long id){
        return (Country) countryService.getReferenceById(id);
    }

    @GetMapping("/{name_country}")
    public Country getByName(@PathVariable("name_country") String name_country){
        return (Country) countryService.getReferenceByName(name_country);
    }

    @PostMapping("")
    public int add(@RequestBody List<Country> countries){
        return countryService.save(countries);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Country updatedCountry){
        Country country = (Country) countryService.getReferenceById(id);

        if(country != null) {
            country.setName(updatedCountry.getName());
            country.setContinent(updatedCountry.getContinent());
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") long id, @RequestBody Country updatedCountry){
        Country country = (Country) countryService.getReferenceById(id);

        if(country != null) {
            if (updatedCountry.getName() != null) country.setName(updatedCountry.getName());
            if (updatedCountry.getContinent() != null) country.setContinent(updatedCountry.getContinent());

            countryService.update(country);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return countryService.delete(id);
    }
}
