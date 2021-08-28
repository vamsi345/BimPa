package com.tc.autobim.domain.model;

import com.tc.autobim.domain.definitions.PlatformName;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class HousePlatformModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PlatformName platformName;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<HouseModel> houseModels;

    public HousePlatformModel(PlatformName platformName, List<HouseModel> houseModels) {
        this.platformName = platformName;
        this.houseModels = houseModels;
    }

    public HousePlatformModel() {

    }
}
