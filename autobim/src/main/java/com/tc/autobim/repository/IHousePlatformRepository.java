package com.tc.autobim.repository;

import com.tc.autobim.domain.model.HousePlatformModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHousePlatformRepository extends JpaRepository<HousePlatformModel, Long> {
}
