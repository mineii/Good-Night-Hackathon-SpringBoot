package com.example.GoodNightHackathon.domain.Restaurant.dto.Mapper;

import com.example.GoodNightHackathon.domain.Restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Response.RestaurantResponseDto;

//요청과 응답의 데이터 저장, entity로부터 데이터를 가져오는 역할

@Component
@RequiredArgsConstructor
public class RestaurantMapper {

    public Restaurant saveDataToEntity(RestaurantCreateRequestDto restaurantCreateRequestDto) {
        return Restaurant.builder()
                .category(restaurantCreateRequestDto.getCategory())
                .restaurantName(restaurantCreateRequestDto.getRestaurantName())
                .build();
    }

    public RestaurantResponseDto getDataFromEntity(Restaurant restaurant) {
        return RestaurantResponseDto.builder()
                .id(restaurant.getId())
                .category(restaurant.getCategory())
                .restaurantName(restaurant.getRestaurantName())
                .build();
    }
}