package com.example.shopapp.service;

import com.example.shopapp.dao.CountryRepository;
import com.example.shopapp.dto.CountryReadDto;
import com.example.shopapp.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public List<Country> findAll() { return countryRepository.findAll(); }

    public List<Country> getReferenceById(Long id) {
        return countryRepository.findById(id).stream().collect(Collectors.toList());
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public Country delete(Long id) { countryRepository.deleteById(id);
        return null;
    }
}
