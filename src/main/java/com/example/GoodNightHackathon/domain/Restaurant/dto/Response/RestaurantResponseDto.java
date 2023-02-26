package com.example.GoodNightHackathon.domain.Restaurant.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RestaurantResponseDto {

    private Long id; //응답을 해야하느데 -> 여기 IDx ->

    private String category;

    private String restaurantName;
}