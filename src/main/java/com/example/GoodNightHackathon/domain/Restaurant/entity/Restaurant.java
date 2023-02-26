package com.example.GoodNightHackathon.domain.Restaurant.entity;
import lombok.*;
import com.example.GoodNightHackathon.global.common.Timestamps;
import com.example.GoodNightHackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter // 필드값 만들어준다, Getter가 없으면 조회가 어려움
//@Setter //
@NoArgsConstructor  // 기본 생성자를 자동으로 추가,
@AllArgsConstructor
@Builder   //Builder할 때는 AllArgsConstructor가 없으면 안되기 때문에 같이 온다고 생각
@Table(name = "restaurant")
@Entity  //연결될 클래스
public class Restaurant extends Timestamps {
    @Id  //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //PK의 생성 규칙 표시, 데이터 삽입 시 1씩 증가해주기 위해 GenerationType.IDENTITY
    @Column (name="id") //열
    private Long id;

    @Column(name = "restaurant_name") //(name = "restaurant_name", length = 50) 이런식으로 속성값을 넣을 수 있음
    private String restaurantName;

    @Column(name = "category")
    private String category;

    private boolean deleted = Boolean.FALSE;

    public Restaurant updateRestaurant(RestaurantUpdateRequestDto restaurantUpdateRequestDto) {

        this.category = restaurantUpdateRequestDto.getCategory();
        this.restaurantName = restaurantUpdateRequestDto.getRestaurantName();
        return this;

    }
}
