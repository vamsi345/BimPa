package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class StairModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String family;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PointModel> points;

    public StairModel(String family, List<PointModel> points) {
        this.family = family;
        this.points = points;
    }

    public StairModel() {

    }
}