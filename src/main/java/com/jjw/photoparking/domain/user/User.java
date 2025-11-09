package com.jjw.photoparking.domain.user;

import com.jjw.photoparking.domain.BaseEntity;
import com.jjw.photoparking.domain.parkinglot.ParkingLot;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kakaoId;

    private String username;

    @OneToMany(mappedBy = "user")
    private List<ParkingLot> parkingLots = new ArrayList<>();

    @Builder
    private User(Long kakaoId, String username) {
        this.kakaoId = kakaoId;
        this.username = username;
    }

    public void addParkingLot(ParkingLot newParkingLot) {

        /*todo
        * 중복 등록 방지용 가드 필요
        */

        this.parkingLots.add(newParkingLot);
        newParkingLot.initializeUser(this);
    }
}
