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
    private ContinentService continentService;

    @GetMapping("")
    public List<Continent> getAll(){
        return continentService.findAll(); }

    @GetMapping("/{id}")
    public List<Continent> getById(@PathVariable("id") long id){
        return continentService.getReferenceById(id);
    }

    @PostMapping("")
    public Continent add(@RequestBody Continent continent){
        return continentService.save(Continent.builder().id(null).name(continent.getName()).build());
    }

    @PutMapping("/{id}")
    public Continent update(@PathVariable("id") long id, @RequestBody Continent continent){
        return continentService.save(Continent.builder().id(id).name(continent.getName()).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        continentService.delete(id);
    }
}
