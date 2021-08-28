package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class WallFamilyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double thickness;

    public WallFamilyModel(String name, double thickness) {
        this.name = name;
        this.thickness = thickness;
    }

    public WallFamilyModel() {

    }
}