package com.example.shopapp.controller;

import com.example.shopapp.entity.Hotel;
import com.example.shopapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public List<Hotel> getAll(){
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") long id){
        return (Hotel) hotelService.getReferenceById(id);
    }

    @GetMapping("/{name_hotel}")
    public Hotel getByName(@PathVariable("name_hotel") String name_hotel){
        return (Hotel) hotelService.getReferenceByName(name_hotel);
    }

    @PostMapping("")
    public int add(@RequestBody List<Hotel> hotels){
        return hotelService.save(hotels);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Hotel updatedHotel){
        Hotel hotel = (Hotel) hotelService.getReferenceById(id);

        if(hotel != null) {
            hotel.setName(updatedHotel.getName());
            hotel.setCity(updatedHotel.getCity());
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") long id, @RequestBody Hotel updatedhotel){
        Hotel hotel = (Hotel) hotelService.getReferenceById(id);

        if(hotel != null) {
            if (updatedhotel.getName() != null) hotel.setName(updatedhotel.getName());
            if (updatedhotel.getCity() != null) hotel.setCity(updatedhotel.getCity());

            hotelService.update(hotel);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return hotelService.delete(id);
    }
}
