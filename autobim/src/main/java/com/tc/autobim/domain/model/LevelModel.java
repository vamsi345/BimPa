package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class LevelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public double elevation;

    public LevelModel(String levelName, double elevation) {
        this.name = levelName;
        this.elevation = elevation;
    }

    public LevelModel() {

    }
}