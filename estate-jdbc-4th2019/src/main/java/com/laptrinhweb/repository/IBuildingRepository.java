package com.laptrinhweb.repository;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.paging.Pageble;

public interface IBuildingRepository extends GenericJDBC<BuildingEntity> {
	List<BuildingEntity> findAll(BuildingSearchBuilder builder,Pageble pageble);
	int countBuildingByProperty(BuildingSearchBuilder builder);
}
