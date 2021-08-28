package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class WallModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OuterWallModel> outerWalls;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<InnerWallModel> innerWalls;

    public WallModel(List<OuterWallModel> outer_Walls, List<InnerWallModel> inner_Walls) {
        this.outerWalls = outer_Walls;
        this.innerWalls = inner_Walls;
    }

    public WallModel() {

    }
}