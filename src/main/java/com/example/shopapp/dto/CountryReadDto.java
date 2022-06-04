package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CountryReadDto {

    private String name;
    private List<CityReadDto> citiesReadDto;
}
