package com.example.shopapp.service;

import com.example.shopapp.entity.City;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    JdbcTemplate jdbcTemplate;

    public List<City> findAll() {
        return jdbcTemplate.query("SELECT id, name_city, country_id FROM city", BeanPropertyRowMapper.newInstance(City.class));
    }

    public List<City> getReferenceById(Long id) {
        return jdbcTemplate.query("SELECT name_city FROM city WHERE" + "id = ?", BeanPropertyRowMapper.
                newInstance(City.class), id);
    }

    public List<City> getReferenceByName(String name) {
        return jdbcTemplate.query("SELECT name_city FROM city WHERE" + "name = ?", BeanPropertyRowMapper.
                newInstance(City.class), name);
    }

    public int save(List<City> cities){
        cities.forEach(city -> jdbcTemplate.update("INSERT INTO cities(name_city, country_id) VALUES(?, ?) ",
                city.getName(), city.getCountry()));
        return 1;
    }

    public int update(City city){
        return jdbcTemplate.update("UPDATE city SET name_city = ?, country_id = ? WHERE id = ?", city.getName(),
                city.getCountry(), city.getId());
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE  FROM city WHERE id = ?", id);
    }
}