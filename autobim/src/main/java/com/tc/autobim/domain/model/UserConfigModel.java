package com.tc.autobim.domain.model;

import lombok.Data;

@Data
public class UserConfigModel {
    private Long houseId;
    private String houseName;
    private double houseLength;
    private double houseWidth;
}
