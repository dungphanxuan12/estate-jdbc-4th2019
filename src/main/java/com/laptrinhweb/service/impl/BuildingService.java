package com.laptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.converter.BuildingConverter;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.entity.RentArea;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.repository.IBuildingRepository;
import com.laptrinhweb.repository.IRentAreaRepository;
import com.laptrinhweb.repository.impl.BuildingRepository;
import com.laptrinhweb.repository.impl.RentAreaRepository;
import com.laptrinhweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	// @Inject
	private IBuildingRepository buildingRepository = new BuildingRepository();

	// @Inject
	private BuildingConverter buildingConverter = new BuildingConverter();

	// @Inject
	private IRentAreaRepository rentAreaRepository = new RentAreaRepository();

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		buildingEntity.setCreatedBy("DUNG");
		buildingEntity.setType(StringUtils.join(buildingDTO.getBuildingTypes(), ","));
		Long id = buildingRepository.insert(buildingEntity);
		for (String item : buildingDTO.getRentArea().split(",")) {
			RentArea rentArea = new RentArea();
			rentArea.setValue(item);
			rentArea.setBuildingId(id);
			rentAreaRepository.insert(rentArea);
		}
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
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

	@Override
	public BuildingDTO findById(Long id) {
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
	}

	@Override
	public void update(BuildingDTO building, Long id) {
		BuildingEntity oldBuilding = buildingRepository.findById(id);
		BuildingEntity newBuilding = buildingConverter.convertToEntity(building);
		newBuilding.setCreatedBy(oldBuilding.getCreatedBy());
		newBuilding.setCreatedDate(oldBuilding.getCreatedDate());
		// rentArea
		updateRenarea(building.getRentArea(), id);
		newBuilding.setType(StringUtils.join(building.getBuildingTypes(), ","));
		buildingRepository.update(newBuilding);
	}

	private void updateRenarea(String rentAreaStr, Long buildingId) {
		rentAreaRepository.deleteByBuilding(buildingId);
		// insert rent area
		for (String item : rentAreaStr.split(",")) {
			RentArea rentArea = new RentArea();
			rentArea.setBuildingId(buildingId);
			rentArea.setValue(item);
			rentAreaRepository.insert(rentAreaStr);
		}

	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			rentAreaRepository.deleteByBuilding(id);
			buildingRepository.delete(id);
		}
	}

	@Override
	public int getTotalItem(BuildingSearchBuilder builder) {
		return buildingRepository.countBuildingByProperty(builder);
	}

}