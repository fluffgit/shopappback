package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EndPlaceDto {

    private Long id;
    private List<CityDto> citiesDto;
    private List<HotelDto> hotelsDto;
    private List<AirportDto> airportsDto;
}
