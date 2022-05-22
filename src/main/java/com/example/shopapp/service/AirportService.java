package com.example.shopapp.service;

import com.example.shopapp.entity.Airport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    JdbcTemplate jdbcTemplate;

    public List<Airport> findAll() {
        return jdbcTemplate.query("SELECT id, name_airport, city_id FROM airport", BeanPropertyRowMapper.newInstance(Airport.class));
    }

    public List<Airport> getReferenceById(Long id) {
        return jdbcTemplate.query("SELECT name_airport FROM airport WHERE" + "id = ?", BeanPropertyRowMapper.
                newInstance(Airport.class), id);
    }

    public List<Airport> getReferenceByName(String name) {
        return jdbcTemplate.query("SELECT name_airport FROM airport WHERE" + "name = ?", BeanPropertyRowMapper.
                newInstance(Airport.class), name);
    }

    public int save(List<Airport> airports){
        airports.forEach(airport -> jdbcTemplate.update("INSERT INTO airports(name_airport, city_id) VALUES(?, ?) ",
                airport.getName(), airport.getCity()));
        return 1;
    }

    public int update(Airport airport){
        return jdbcTemplate.update("UPDATE airport SET name_airport = ?, city_id = ? WHERE id = ?", airport.getName(),
                airport.getCity(), airport.getId());
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE  FROM airport WHERE id = ?", id);
    }
}
