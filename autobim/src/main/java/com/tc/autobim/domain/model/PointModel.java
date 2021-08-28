package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class PointModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double x;
    private double y;
    private double z;

    public PointModel(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PointModel() {

    }
}