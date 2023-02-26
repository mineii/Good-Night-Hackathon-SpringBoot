package com.example.GoodNightHackathon.domain.Restaurant.repository;

import com.example.GoodNightHackathon.domain.Restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

//extends JpaRepository<Restaurant, Long> -> extends JpaRepository<entity, id값>
// 미리 검색 메소드를 정의해놓은,
// entity에서 데이터 조회 및 저장, 변경, 삭제할 때 spring Jpa를 제공하는 Repository