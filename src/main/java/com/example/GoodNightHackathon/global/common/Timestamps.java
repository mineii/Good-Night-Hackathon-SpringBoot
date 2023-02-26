package com.example.GoodNightHackathon.global.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우, 데이터 트래킹 필드로 인식
@EntityListeners(AuditingEntityListener.class) //EntityListeners:엔티티의 변화를 감지하고 데이블의 데이터 조작, AuditingEntityListener:자동으로 시간을 매핑해주고 이를 데이터베이스에 넣어줌
@Getter
public class Timestamps {
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();  //시간이 출력되도록 함

    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime deletedAt = LocalDateTime.now();
}