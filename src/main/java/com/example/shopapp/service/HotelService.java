package com.example.shopapp.service;

import com.example.shopapp.dao.HotelRepository;
import com.example.shopapp.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public List<Hotel> findAll() { return hotelRepository.findAll(); }

    public List<Hotel> getReferenceById(Long id) {
        return hotelRepository.findById(id).stream().collect(Collectors.toList());
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel delete(Long id) { hotelRepository.deleteById(id);
        return null;
    }
}
