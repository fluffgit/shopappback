package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class CountryDto {

    private Long id;
    private String name;
    private ContinentDto continentDto;
}
