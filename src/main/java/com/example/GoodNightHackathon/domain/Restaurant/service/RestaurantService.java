package com.example.GoodNightHackathon.domain.Restaurant.service;

import com.example.GoodNightHackathon.domain.Restaurant.repository.RestaurantRepository;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.example.GoodNightHackathon.domain.Restaurant.entity.Restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    //private : return이 되기 전까지 값이 절대 바뀌지 않음
    private final RestaurantMapper MAPPER; //MAPPER를 통해 서비스단으로 넘어온 것임

    private final RestaurantRepository REPOSITORY;

    private final EntityManager entityManager;

    private final int NULL_SIZE = 0;

    @Transactional
    public Restaurant insertRestaurant(RestaurantCreateRequestDto restaurantCreateRequestDto) {
        return REPOSITORY.save(MAPPER.saveDataToEntity(restaurantCreateRequestDto));
    }
    //RestaurantCreateRequestDto를 통해 받아온 데이터를 REPOSITORY에 반환해줌
    //(restaurantCreateRequestDto)이 객체를 저장하겠다(saveDataToEntity)


    @Transactional
    public List<Restaurant> findAllRestaurant() {
        return REPOSITORY.findAll(); //전체 찾기
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        REPOSITORY.deleteById(id); //삭제
    }

    @Transactional
    public Restaurant findById(Long id) {
        Optional<Restaurant> restaurant = REPOSITORY.findById(id);
        if (restaurant.isPresent()) {
            return restaurant.get();
        }
        throw new EntityNotFoundException(
                "ID를 찾지 못했습니다"
        );
    }

//    @Transactional
//    public Restaurant updateRestaurant(Long id, RestaurantCreateRequestDto restaurantCreateRequestDto) {
//        Optional<Restaurant> optionalRestaurant = REPOSITORY.findById(id);
//        if (!optionalRestaurant.isPresent()) {
//            throw new EntityNotFoundException(
//                    "ID가 없습니다"
//            );
//        }
//        Restaurant restaurant = optionalRestaurant.get();
//        restaurant.setCategory(restaurant.getCategory());
//        restaurant.setRestaurantName(restaurant.getRestaurantName());
//        return REPOSITORY.save(restaurant);

//}

    @Transactional
    public Restaurant updateRestaurant(RestaurantUpdateRequestDto restaurantUpdateRequestDto) {
        Restaurant restaurant = isRestaurantExisted(restaurantUpdateRequestDto.getId());
        return restaurant.updateRestaurant(restaurantUpdateRequestDto);
    }

    private Restaurant isRestaurantExisted(Long id) {
        Restaurant restaurant = REPOSITORY.findById(id).orElseThrow(() -> new NullPointerException());

        return restaurant;
    }
}