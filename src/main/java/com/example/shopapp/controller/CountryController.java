package com.example.shopapp.controller;

import com.example.shopapp.entity.Continent;
import com.example.shopapp.entity.Country;
import com.example.shopapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> getAll(){
        return countryService.findAll(); }

    @GetMapping("/{id}")
    public List<Country> getById(@PathVariable("id") long id){
        return countryService.getReferenceById(id); }

    @PostMapping("")
    public Country add(@RequestBody Country newcountry, @RequestBody Continent continent){
        Country country = new Country(null, newcountry.getName(), Continent.builder()
                .id(continent.getId()).name(continent.getName()).build(), null);
        return countryService.save(country);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Country country){
        countryService.save(Country.builder().id(id).name(country.getName()).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        countryService.delete(id);
    }
}
