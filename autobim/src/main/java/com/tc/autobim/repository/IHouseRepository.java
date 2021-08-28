package com.tc.autobim.repository;

import com.tc.autobim.domain.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHouseRepository extends JpaRepository<HouseModel,Long> {
}
