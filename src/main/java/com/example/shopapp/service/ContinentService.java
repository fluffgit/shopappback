package com.example.shopapp.service;

import com.example.shopapp.entity.Continent;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {


    JdbcTemplate jdbcTemplate;

    public List<Continent> findAll(){
        return  jdbcTemplate.query("SELECT id, name_continent FROM continent", BeanPropertyRowMapper.newInstance(Continent.class));
    }

    public List<Continent> getReferenceById(Long id){
        return  jdbcTemplate.query("SELECT name_continent FROM continent WHERE" + "id = ?",BeanPropertyRowMapper.
                newInstance(Continent.class), id);
    }

    public List<Continent> getReferenceByName(String name){
        return  jdbcTemplate.query("SELECT name_continent FROM continent WHERE" + "name = ?",BeanPropertyRowMapper.
                newInstance(Continent.class), name);
    }


    public int save(List<Continent> continents){
        continents.forEach(continent -> jdbcTemplate.update("INSERT INTO continents(name_continent) VALUES(?) ",
                continent.getName()));
        return 1;
    }

    public int update(Continent continent){
        return jdbcTemplate.update("UPDATE continent SET name_continent, WHERE id = ?",continent.getName(), continent.getId());
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE  FROM continent WHERE id = ?", id);
    }
};
