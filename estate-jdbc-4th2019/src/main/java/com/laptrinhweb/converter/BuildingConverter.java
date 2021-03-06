package com.laptrinhweb.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.entity.RentArea;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.repository.IRentAreaRepository;
import com.laptrinhweb.repository.impl.RentAreaRepository;

public class BuildingConverter {

	// @Inject
	private IRentAreaRepository rentAreaRepository = new RentAreaRepository();

	public BuildingDTO convertToDTO(BuildingEntity buildingEntity) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("buildingid", buildingEntity.getId());
		// JAVA 7
//		List<RentArea> rentAreas = rentAreaRepository.findAll(condition, new PageRequest(null, null, null));
//		List<String> areas = new ArrayList<String>();
//		for (RentArea item : rentAreas) {
//			areas.add(item.getValue());
//		}
//		if (areas.size() > 0)
//			result.setRentArea(StringUtils.join(areas, ","));
		// JAVA 8
		List<String> areas = rentAreaRepository.findAll(condition, new PageRequest(null, null, null)).stream()
				.map(RentArea::getValue).collect(Collectors.toList());
		if (areas.size() > 0)
			result.setRentArea(StringUtils.join(areas, ","));
		if (StringUtils.isNotBlank(buildingEntity.getType())) {
			result.setBuildingTypes(buildingEntity.getType().split(","));
		}
		return result;
	}

	public BuildingEntity convertToEntity(BuildingDTO buildingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingEntity result = modelMapper.map(buildingDTO, BuildingEntity.class);
		if (buildingDTO.getNumberOfBasement() != null)
			result.setNumberOfBasement((buildingDTO.getNumberOfBasement()));
		if (buildingDTO.getBuildingArea() != null)
			result.setBuildingArea((buildingDTO.getBuildingArea()));
		return result;
	}

}
