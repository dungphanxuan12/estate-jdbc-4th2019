package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.paging.Pageble;

public interface IBuildingService {

	BuildingDTO save(BuildingDTO newBuilding);

	List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder, Pageble pageble);

	BuildingDTO findById(Long id);
	
	
}
