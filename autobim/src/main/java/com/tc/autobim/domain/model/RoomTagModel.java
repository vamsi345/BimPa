package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomTagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST)
    private PointModel point;

    public RoomTagModel(String name, PointModel point) {
        this.name = name;
        this.point = point;
    }

    public RoomTagModel() {

    }
}