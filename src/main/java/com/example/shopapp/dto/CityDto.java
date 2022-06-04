package com.example.shopapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CityDto {

    private Long id;
    private String name;
}
