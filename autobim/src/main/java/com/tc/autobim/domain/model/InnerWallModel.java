package com.tc.autobim.domain.model;

import com.tc.autobim.domain.definitions.WallOrientation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class InnerWallModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double height;
    private WallOrientation orientation;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private WallFamilyModel family;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private LevelModel levelStart;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private LevelModel levelEnd;
    private String revitIndex;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<InsertModel> inserts;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PointModel> point;

    public InnerWallModel(String type, double height, WallOrientation orientation, WallFamilyModel family, LevelModel levelStart, LevelModel levelEnd, String revitIndex, List<InsertModel> inserts, List<PointModel> point) {
        this.type = type;
        this.height = height;
        this.orientation = orientation;
        this.family = family;
        this.levelStart = levelStart;
        this.levelEnd = levelEnd;
        this.revitIndex = revitIndex;
        this.inserts = inserts;
        this.point = point;
    }

    public InnerWallModel(String type, double height, WallOrientation orientation, WallFamilyModel family, LevelModel levelStart, LevelModel levelEnd, String revitIndex, List<PointModel> point) {
        this.type = type;
        this.height = height;
        this.orientation = orientation;
        this.family = family;
        this.levelStart = levelStart;
        this.levelEnd = levelEnd;
        this.revitIndex = revitIndex;
        this.point = point;
    }

    public InnerWallModel() {

    }
}