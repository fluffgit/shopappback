package com.example.shopapp.service;

import com.example.shopapp.entity.Hotel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    JdbcTemplate jdbcTemplate;

    public List<Hotel> findAll(){
        return jdbcTemplate.query("SELECT id, name_hotel, city_id FROM hotel", BeanPropertyRowMapper.newInstance(Hotel.class));
    }

    public List<Hotel> getReferenceById(Long id){
        return jdbcTemplate.query("SELECT name_hotel FROM hotel WHERE" + "id = ?", BeanPropertyRowMapper.newInstance(Hotel.class), id);
    }

    public List<Hotel> getReferenceByName(String name){
        return jdbcTemplate.query("SELECT name_hotel FROM hotel WHERE" + "name = ?", BeanPropertyRowMapper.
                newInstance((Hotel.class)), name);
    }

    public int save(List<Hotel> hotels){
        hotels.forEach(hotel -> jdbcTemplate.update("INSERT INTO hotels(name_hotel, city_id) VALUES(?, ?) ",
                hotel.getName(), hotel.getCity()));
        return 1;
    }

    public int update(Hotel hotel){
        return jdbcTemplate.update("UPDATE hotel SET name_hotel = ?, city_id = ? WHERE id = ?", hotel.getName(),
                hotel.getCity(), hotel.getId());
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE  FROM hotel WHERE id = ?", id);
    }
}
