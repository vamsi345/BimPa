package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class RoofModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String family;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LevelModel startLevel;
    @ElementCollection
    private List<Double> offSets;
    @ElementCollection
    private List<Double> slope;
    @ElementCollection
    private List<Double> tangents;
    private double angle;
    private double length;
    private double width;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PointModel> points;

    public RoofModel(String type, String family, LevelModel startLevel, List<Double> offSets, List<Double> slope, List<Double> tangents, double angle, double length, double width, List<PointModel> points) {
        this.type = type;
        this.family = family;
        this.startLevel = startLevel;
        this.offSets = offSets;
        this.slope = slope;
        this.tangents = tangents;
        this.angle = angle;
        this.length = length;
        this.width = width;
        this.points = points;
    }

    public RoofModel() {

    }
}

