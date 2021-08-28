package com.tc.autobim.controller;

import com.tc.autobim.domain.model.*;
import com.tc.autobim.repository.IHouseRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserConfig")
public class UserConfigController {
    @Autowired
    private IHouseRepository repository;

    @PostMapping
    public HouseModel postUserConfig(@RequestBody UserConfigModel userConfigModel)
    {
        Optional<HouseModel> house=repository.findById(userConfigModel.getHouseId());
        HouseModel houseModel=house.get();
        return houseModel;
    }
}
