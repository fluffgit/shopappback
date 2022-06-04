package com.example.shopapp.service;

import com.example.shopapp.dao.PlaceRepository;
import com.example.shopapp.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAll() { return placeRepository.findAll(); }

    public List<Place> getReferenceById(Long id) {
        return placeRepository.findById(id).stream().collect(Collectors.toList());
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public Place delete(Long id) { placeRepository.deleteById(id);
        return null;
    }
}
