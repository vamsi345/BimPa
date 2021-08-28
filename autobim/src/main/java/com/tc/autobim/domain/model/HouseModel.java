package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class HouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String houseName;
    private double houseLength;
    private double houseWidth;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<LevelModel> levels;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ElementModel> elements;
    @OneToOne(cascade = CascadeType.PERSIST)
    private RoofModel roof;

    public HouseModel(String houseName, double houseLength, double houseWidth, List<LevelModel> levels, List<ElementModel> elements, RoofModel roof) {
        this.houseName = houseName;
        this.houseLength = houseLength;
        this.houseWidth = houseWidth;
        levels = levels;
        elements = elements;
        roof = roof;
    }

    public HouseModel() {

    }
}