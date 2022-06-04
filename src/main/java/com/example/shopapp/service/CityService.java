package com.example.shopapp.service;

import com.example.shopapp.dao.CityRepository;
import com.example.shopapp.entity.City;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public List<City> findAll() { return cityRepository.findAll(); }

    public List<City> getReferenceById(Long id) {
        return cityRepository.findById(id).stream().collect(Collectors.toList());
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public City delete(Long id) { cityRepository.deleteById(id);
        return null;
    }
}