package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StartPlaceDto {

    private Long id;
    private List<CityDto> citiesDto;
    private List<AirportDto> airportsDto;

}
