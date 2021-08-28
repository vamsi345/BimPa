package com.tc.autobim.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tc.autobim.domain.definitions.ElementType;
import com.tc.autobim.domain.definitions.PlatformName;
import com.tc.autobim.domain.definitions.WallOrientation;
import com.tc.autobim.domain.model.*;
import com.tc.autobim.repository.IHousePlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/HousePlatform")
public class HousePlatformController {

    @Autowired
    private IHousePlatformRepository repository;

    @GetMapping("/{id}")
    public Optional<HousePlatformModel> getById(@PathVariable Long id){
        return repository.findById(id);

    }

    @PostMapping
    @JsonIgnore
    public HouseModel createHouse(){
        //Levels


        LevelModel levelModel1=new LevelModel("EG-UK-RB",-0.16);
        LevelModel levelModel2=new LevelModel("EG-OK-RB",0);
        LevelModel levelModel3=new LevelModel("EG-OK-FB",0.145);
        LevelModel levelModel4=new LevelModel("OG-UK-RB",2.645);
        LevelModel levelModel5=new LevelModel("OG-OK-RB",2.845);
        LevelModel levelModel6=new LevelModel("OG-OK-FB",2.94);
        LevelModel levelModel7=new LevelModel("DG-UK-FB",5.39);
        LevelModel levelModel8=new LevelModel("DG-UK-RB",5.45);
        LevelModel levelModel9=new LevelModel("DG-OK-RB",5.65);
        LevelModel levelModel10=new LevelModel("Kniestock",3.91);
        List<LevelModel> levelModels=new ArrayList<>();
        levelModels.add(levelModel1);
        levelModels.add(levelModel2);
        levelModels.add(levelModel3);
        levelModels.add(levelModel4);
        levelModels.add(levelModel5);
        levelModels.add(levelModel6);
        levelModels.add(levelModel7);
        levelModels.add(levelModel8);
        levelModels.add(levelModel9);
        levelModels.add(levelModel10);


        //House platform
        List<HouseModel> houseModels=new ArrayList<>();
        HousePlatformModel housePlatformModel=new HousePlatformModel(PlatformName.Flair,houseModels);

        //Roof

        List<Double> offsets= Arrays.asList(-0.73, 0.33, 0.73, -0.33);
        List<Double> slope=Arrays.asList(0.0,2.0);
        List<Double> tangents=Arrays.asList(45.0,45.0);
        List<PointModel> roofPoints= Arrays.asList(new PointModel(0, 0, 0),new PointModel(10.74, 0, 0),new PointModel(10.74, 9.24, 0),new PointModel(0, 9.24, 0));
        RoofModel roof=new RoofModel("Binderdach","Roof_test",levelModel10,offsets,slope,tangents,0,10.84312158943287,3.665036012018214,roofPoints);


        //Elements
        List<ElementModel> elements=new ArrayList<>();

        //Element1
        PointModel p1=new PointModel(0,0,0);
        PointModel p2=new PointModel(10.74,0,0);
        PointModel p3=new PointModel(0,9.24,0);
        PointModel p4=new PointModel(10.74,9.24,0);
        FloorModel floor1= new FloorModel("Base Plate",levelModel1,levelModel3,1,0.305, Arrays.asList(p1,p2, p4,p3));
        WallFamilyModel wallFamilyModel= new WallFamilyModel("OT_24",0.2);
        WallFamilyModel wallFamilyModel2= new WallFamilyModel("Inner Walls 11.5 cm",0.2);
        List<OuterWallModel> outerWallModels1=Arrays.asList(new OuterWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel,
                        levelModel2,
                        levelModel4,
                        "EG_Outer_Walls_Horizontal_1",
                        Arrays.asList(new InsertModel("Window","Kuche_2",0.15,false,false,0),
                                new InsertModel("Door","Elisa",0.37019952054794525,false,false,0),
                                new InsertModel("Window","HAR",0.6876712328767124,false,false,0)),
                        Arrays.asList(new PointModel(0,0,0),new PointModel(10.74,0,0))),
                new OuterWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel,
                        levelModel2,
                        levelModel4,
                        "EG_Outer_Walls_Horizontal_2",
                        Arrays.asList(new InsertModel("Window","Model_1_Bodentiefefenster_zwei_Flugel",0.2328767123287671,false,false,0),
                                new InsertModel("Window","Model_1_Bodentiefefenster_zwei_Flugel",0.7671232876712328,false,false,0)),
                        Arrays.asList(new PointModel(0,9.24,0),new PointModel(10.74,9.24,0))),
                new OuterWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel,
                        levelModel2,
                        levelModel4,
                        "EG_Outer_Walls_Vertical_3",
                        Arrays.asList(new InsertModel("Window","Kuche_1",0.7205882352941176,false,false,0)),
                        Arrays.asList(new PointModel(0,0,0),new PointModel(0,9.24,0))),
                new OuterWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel,
                        levelModel2,
                        levelModel4,
                        "EG_Outer_Walls_Vertical_4",
                        Arrays.asList(new InsertModel("Door","HAR_Door_Neu",0.16470588235294117,false,false,0),
                                new InsertModel("Window","WC",0.4235294117647059,false,false,0)),
                        Arrays.asList(new PointModel(0,9.24,0),new PointModel(10.74,9.24,0)))
                );
        List<InnerWallModel> innerWallModels1=Arrays.asList(new InnerWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Horizontal_1",
                        Arrays.asList(new InsertModel("Door","Innertur",0.5,false,false,0)),
                        Arrays.asList(new PointModel(8.597884931506849,2.320870588235294,0),new PointModel(9.939649315068493,2.320870588235294,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Horizontal_2",
                        Arrays.asList(new InsertModel("Door","Innertur",0.5,false,false,0)),
                        Arrays.asList(new PointModel(6.591123287671232,3.0872470588235292,0),new PointModel(8.597884931506849,3.0872470588235292,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Horizontal_3",
                        Arrays.asList(new PointModel(9.939649315068493,3.098117647058824,0),new PointModel(10.74,3.098117647058824,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Horizontal,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Horizontal_4",
                        Arrays.asList(new InsertModel("Door","Sliding_door(wooden)",0.42019952054794524,false,false,0),
                                new InsertModel("Door","Innertur",0.6591422121896162,false,false,0)),
                        Arrays.asList(new PointModel(0,4.728705882352941,0),new PointModel(10.74,4.728705882352941,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Vertical_5",
                        Arrays.asList(new PointModel(3.2543671232876714,0,0),new PointModel(3.2543671232876714,4.728705882352941,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Vertical_6",
                        Arrays.asList(new PointModel(6.591123287671232,0,0),new PointModel(6.591123287671232,3.0872470588235292,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Vertical_7",
                        Arrays.asList(new PointModel(8.597884931506849,2.320870588235294,0),new PointModel(8.597884931506849,4.728705882352941,0))),
                new InnerWallModel("Normal", 2.645,WallOrientation.Vertical,
                        wallFamilyModel2,
                        levelModel2,
                        levelModel4,
                        "EG_Inner_Walls_Vertical_8",
                        Arrays.asList(new PointModel(9.939649315068493,2.320870588235294,0),new PointModel(9.939649315068493,3.098117647058824,0)))

                );
        WallModel wallModel1=new WallModel(outerWallModels1,innerWallModels1);
        ElementModel element1=new ElementModel(ElementType.EG,wallModel1,floor1);
        elements.add(element1);



        //House Model
        HouseModel house=new HouseModel();
        house.setHouseName("Flair110");
        house.setHouseLength(9.125);
        house.setHouseWidth(8.5);
        house.setElements(elements);
        house.setLevels(levelModels);
        house.setRoof(roof);
        housePlatformModel.setHouseModels(Arrays.asList(house));
        repository.saveAndFlush(housePlatformModel);

        return house;
    }
}
