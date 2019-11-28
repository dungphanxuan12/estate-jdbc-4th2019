package com.laptrinhweb.utils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


import com.laptrinhweb.enums.BuildingType;
import com.laptrinhweb.enums.DistrictEnum;

public class DataUtils {

	public static Map<String, String> getDistricts() {
		StandardCharsets.UTF_8.name();
		Map<String, String> results = new HashMap<String, String>();
		Stream.of(DistrictEnum.values()).forEach(district -> {
			results.put(district.name(), district.getValue());
		});
		return results;
	}

	public static Map<String, String> getBuildingTypes() {
		Map<String, String> results = new HashMap<String, String>();
		Stream.of(BuildingType.values()).forEach(type -> {
			results.put(type.name(), type.getValue());
		});
		return results;
	}

}
