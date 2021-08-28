package com.tc.autobim.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class InsertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String family;
    private double ratio;
    private boolean isFaceFlipped;
    private boolean isHandFlipped;
    private double brh;

    public InsertModel(String type, String family, double ratio, boolean isFaceFlipped, boolean isHandFlipped, double brh) {
        this.type = type;
        this.family = family;
        this.ratio = ratio;
        this.isFaceFlipped = isFaceFlipped;
        this.isHandFlipped = isHandFlipped;
        this.brh = brh;
    }

    public InsertModel() {

    }
}