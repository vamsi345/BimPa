package com.tc.autobim.controller;

import com.tc.autobim.domain.model.HouseModel;
import com.tc.autobim.domain.model.UserConfigModel;
import com.tc.autobim.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/House")
public class HouseController {
    @Autowired
    private IHouseRepository repository;

    @GetMapping
    public List<HouseModel> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<HouseModel> findByID(@PathVariable Long id){
        Optional<HouseModel> houseModel=repository.findById(id);

        return houseModel;

    }

}
