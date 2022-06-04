package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ContinentReadDto {

    private Long id;
    private String name;
    private List<CountryReadDto> countriesReadDto;
}
