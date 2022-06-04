package com.example.shopapp.service;

import com.example.shopapp.dao.ContinentRepository;
import com.example.shopapp.entity.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContinentService {

    @Autowired
     private ContinentRepository continentRepository;


    public List<Continent> findAll() { return continentRepository.findAll(); }

    public List<Continent> getReferenceById(Long id) {
        return continentRepository.findById(id).stream().collect(Collectors.toList());
    }

    public Continent save(Continent continent) {
        return continentRepository.save(continent);
    }

    public Continent delete(Long id){  continentRepository.deleteById(id);
        return null;
    }
};
