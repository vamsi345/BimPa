package com.tc.autobim.repository;


import com.tc.autobim.domain.model.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelRepository extends JpaRepository<LevelModel, Long> {
}
