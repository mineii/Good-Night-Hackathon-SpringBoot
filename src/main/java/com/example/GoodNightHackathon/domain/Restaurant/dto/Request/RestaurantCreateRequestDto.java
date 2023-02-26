package com.example.GoodNightHackathon.domain.Restaurant.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantCreateRequestDto {

    private String category;

    private String restaurantName;
}