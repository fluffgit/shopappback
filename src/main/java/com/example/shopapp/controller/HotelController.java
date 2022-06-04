package com.example.shopapp.controller;

import com.example.shopapp.dto.HotelDto;
import com.example.shopapp.entity.Hotel;
import com.example.shopapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public List<Hotel> getAll(){
        return hotelService.findAll(); }

    @GetMapping("/{id}")
    public List<Hotel> getById(@PathVariable("id") long id){
        return hotelService.getReferenceById(id); }

    @PostMapping("")
    public Hotel add(@RequestBody Hotel newHotel){
        return hotelService.save(Hotel.builder().name(newHotel.getName()).build());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Hotel hotel){
        hotelService.save(Hotel.builder().id(id).name(hotel.getName()).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        hotelService.delete(id);
    }
}
