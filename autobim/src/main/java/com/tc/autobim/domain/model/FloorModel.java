package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class FloorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String family;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LevelModel levelStart;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LevelModel levelEnd;
    private int revitIndex;
    private double offSet;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PointModel> points;

    public FloorModel(String family, LevelModel levelStart, LevelModel levelEnd, int revitIndex, double offSet, List<PointModel> points) {
        this.family = family;
        this.levelStart = levelStart;
        this.levelEnd = levelEnd;
        this.revitIndex = revitIndex;
        this.offSet = offSet;
        this.points = points;
    }

    public FloorModel() {

    }
}