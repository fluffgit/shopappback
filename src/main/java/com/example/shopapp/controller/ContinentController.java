package com.example.shopapp.controller;

import com.example.shopapp.entity.Continent;
import com.example.shopapp.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continents")
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @GetMapping("")
    public List<Continent> getAll(){
        return continentService.findAll();
    }

    @GetMapping("/{id}")
    public Continent getById(@PathVariable("id") long id){
        return (Continent) continentService.getReferenceById(id);
    }

    @GetMapping("/{name_continent}")
    public Continent getByName(@PathVariable("name_continent") String name_continent){
        return (Continent) continentService.getReferenceByName(name_continent);
    }

    @PostMapping("")
    public int add(@RequestBody List<Continent> continents){
       return continentService.save(continents);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Continent updatedContinent){
        Continent continent = (Continent) continentService.getReferenceById(id);

        if(continent != null) {
            continent.setName(updatedContinent.getName());
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") long id, @RequestBody Continent updatedContinent){
        Continent continent = (Continent) continentService.getReferenceById(id);

        if(continent != null) {
            if (updatedContinent.getName() != null) continent.setName(updatedContinent.getName());

            continentService.update(continent);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return continentService.delete(id);
    }

}
