package com.tc.autobim.domain.model;

import com.tc.autobim.domain.definitions.ElementType;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class ElementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ElementType type;
    @OneToOne(cascade = CascadeType.PERSIST)
    private WallModel walls;
    @OneToOne(cascade = CascadeType.PERSIST)
    private FloorModel floor;
    @OneToOne
    @Embedded.Nullable
    private StairModel stairs;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<RoomTagModel> roomTags;


    public ElementModel() {

    }
    public ElementModel(ElementType type, WallModel walls, FloorModel floor, StairModel stairs, List<RoomTagModel> roomTags) {
        this.type = type;
        this.walls = walls;
        this.floor = floor;
        this.stairs = stairs;
        this.roomTags = roomTags;
    }

    public ElementModel(ElementType type, WallModel walls, FloorModel floor) {
        this.type = type;
        this.walls = walls;
        this.floor = floor;
    }
}