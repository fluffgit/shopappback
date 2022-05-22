package com.example.shopapp.service;

import com.example.shopapp.entity.Country;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    JdbcTemplate jdbcTemplate;

    public List<Country> findAll(){
        return  jdbcTemplate.query("SELECT id, name_cuntry FROM country", BeanPropertyRowMapper.newInstance(Country.class));
    }

    public List<Country> getReferenceById(Long id){
        return  jdbcTemplate.query("SELECT name_country FROM country WHERE" + "id = ?",BeanPropertyRowMapper.
                newInstance(Country.class), id);
    }

    public List<Country> getReferenceByName(String name){
        return  jdbcTemplate.query("SELECT name_country FROM country WHERE" + "name = ?",BeanPropertyRowMapper.
                newInstance(Country.class), name);
    }

    public int save(List<Country> countries){
        countries.forEach(country -> jdbcTemplate.update("INSERT INTO countries(name_country) VALUES(?) ",
                country.getName()));
        return 1;
    }

    public int update(Country country){
        return jdbcTemplate.update("UPDATE country SET name_country, WHERE id = ?",country.getName(), country.getId());
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE  FROM country WHERE id = ?", id);
    }
}
