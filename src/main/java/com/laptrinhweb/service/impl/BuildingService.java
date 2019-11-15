package com.laptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.laptrinhweb.converter.BuildingConverter;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.repository.IBuildingRepository;
import com.laptrinhweb.repository.impl.BuildingRepository;
import com.laptrinhweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	private IBuildingRepository buildingRepository;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {

		BuildingConverter buildingConverter = new BuildingConverter();

		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository.insert(buildingEntity);
		return null;
	}

	@Override
	public List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble) {

		return null;
	}

}
