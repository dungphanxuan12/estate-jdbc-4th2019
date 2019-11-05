package com.laptrinhweb.repository;

import com.laptrinhweb.entity.BuildingEntity;

public interface IBuildingRepository extends GenericJDBC<BuildingEntity> {

	Long insert(BuildingEntity buildingEntity);
}
