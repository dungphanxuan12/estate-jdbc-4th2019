package com.laptrinhwebrework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebrework.dto.BuildingDTO;

/**
 * The BuildingMapper Class implements a Rowmapper Interface
 * 
 *
 * @author Dung Phan Xuan
 * @version 1.0
 * @since 2020-05-14
 */
public class BuildingMapper implements Rowmapper<BuildingDTO> {

	@Override
	public BuildingDTO maprow(ResultSet resultSet) {

		try {
			BuildingDTO building = new BuildingDTO();
			String name = resultSet.getString("name");
			building.setName(name);
			return building;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
