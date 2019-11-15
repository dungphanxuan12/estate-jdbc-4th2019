package com.laptrinhweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.paging.Pageble;

public interface IBuildingService {
	
	BuildingDTO save(BuildingDTO newBuilding);
	
	List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble);
}
