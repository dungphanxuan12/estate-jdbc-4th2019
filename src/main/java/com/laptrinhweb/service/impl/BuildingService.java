package com.laptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.converter.BuildingConverter;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.repository.IBuildingRepository;
import com.laptrinhweb.service.IBuildingService;

@SuppressWarnings("unused")
public class BuildingService implements IBuildingService {

	@Inject
	private IBuildingRepository buildingRepository;

	@Inject
	private BuildingConverter buildingConverter;

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository.insert(buildingEntity);
		return null;
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder, Pageble pageble) {
		List<BuildingEntity> buildingentities = buildingRepository.findAll(buildingSearchBuilder, pageble);
		List<BuildingDTO> results = buildingentities.stream().map(item -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());
		return results;
		// JAVA 7 version code
//		for (BuildingEntity item : buildingentities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
//			results.add(buildingDTO);
//		}

	}

}