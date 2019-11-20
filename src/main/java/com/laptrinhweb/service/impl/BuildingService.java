package com.laptrinhweb.service.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.converter.BuildingConverter;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.repository.IBuildingRepository;
import com.laptrinhweb.repository.impl.BuildingRepository;
import com.laptrinhweb.service.IBuildingService;

@SuppressWarnings("unused")
public class BuildingService implements IBuildingService {

	private static IBuildingRepository buildingRepository;

	private static BuildingConverter buildingConverter;

	public static IBuildingRepository getBuildingRepository() {

		if (buildingRepository == null) {
			buildingRepository = new BuildingRepository();
		}

		return buildingRepository;
	}

	public static BuildingConverter getBuildingConverter() {

		if (buildingConverter == null) {
			buildingConverter = new BuildingConverter();
		}
		return buildingConverter;
	}

//	public BuildingService() {
//		
//		if (buildingRepository != null) {
//			buildingRepository = new BuildingRepository();
//		}
//		
//		if (buildingConverter != null) {
//			buildingConverter = new BuildingConverter();
//		}
//
//	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {

		BuildingConverter buildingConverter = new BuildingConverter();

		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = getBuildingRepository().insert(buildingEntity);
		return null;
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder, Pageble pageble) {
		List<BuildingEntity> buildingentities = getBuildingRepository().findAll(buildingSearchBuilder, pageble);
		List<BuildingDTO> results = buildingentities.stream().map(item -> getBuildingConverter().convertToDTO(item))
				.collect(Collectors.toList());
		return results;
		// JAVA 7 version code
//		for (BuildingEntity item : buildingentities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
//			results.add(buildingDTO);
//		}

	}

}