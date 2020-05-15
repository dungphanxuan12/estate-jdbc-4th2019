package com.laptrinhweb.repository.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.repository.IBuildingRepository;

public class BuildingRepository extends AbstractJDBC<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		Map<String, Object> properties = buildMapSearch(builder);
		StringBuilder whereClause = buildWhereClause(builder);
		return super.findAll(properties, pageble, whereClause.toString());
	}

	private Map<String, Object> buildMapSearch(BuildingSearchBuilder buildingSearchBuilder) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!"".equals(field.getName()) && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("rentArea")) {
					field.setAccessible(true);
					if (field.get(buildingSearchBuilder) != null) {
						if (field.getName().equals("numberOfBasement") || field.getName().equals("buildingArea")) {
							result.put(field.getName().toLowerCase(),
									Integer.parseInt(((String) field.get(buildingSearchBuilder))));
						} else {
							result.put(field.getName().toLowerCase(), field.get(buildingSearchBuilder));
						}
					}
				}
			}
		} catch (IllegalArgumentException |IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int countBuildingByProperty(BuildingSearchBuilder builder) {
		Map<String, Object> properties = buildMapSearch(builder);
		StringBuilder whereClause = buildWhereClause(builder);
		return countByProperty(properties, whereClause.toString());
	}

	private StringBuilder buildWhereClause(BuildingSearchBuilder builder) {
		StringBuilder whereClause = new StringBuilder("");
		if (StringUtils.isNotBlank(builder.getCostRentFrom())) {
			whereClause.append(" AND costrent >= " + builder.getCostRentFrom() + " ");
		}
		if (StringUtils.isNotBlank(builder.getCostRentTo())) {
			whereClause.append(" AND costrent <= " + builder.getCostRentTo() + "");
		}
		if (StringUtils.isNotBlank(builder.getRentAreaFrom()) || StringUtils.isNotBlank(builder.getRentAreaTo())) {
			whereClause.append(" AND EXIST (SELECT * FROM rentarea ra WHERE (ra.buildingid = A.id ");
			if (builder.getRentAreaFrom() != null) {
				whereClause.append(" AND ra.value >= " + builder.getRentAreaFrom() + " ");
			}
			if (builder.getRentAreaTo() != null) {
				whereClause.append(" AND ra.value <= " + builder.getRentAreaTo() + " ");
			}
			whereClause.append(" ))");

		}
		if (builder.getBuildingTypes().length > 0) {
			whereClause.append(" AND (A.type LIKE '%" + builder.getBuildingTypes()[0] + "%'");
			// JAVA 7 version
//			for (String type : builder.getBuildingTypes()) {
//				if (!type.equals(builder.getBuildingTypes()[0])) {
//					whereClause.append("OR A.type LIKE '%" + type + "%'");
//				}
//			}s

			// JAVA 8
			Arrays.stream(builder.getBuildingTypes()).filter(item -> !item.equals(builder.getBuildingTypes()[0]))
					.forEach(item -> whereClause.append(" OR A.type LIKE '%" + item + "%'"));
			whereClause.append(" )");
		}
		return whereClause;
	}

}
