package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.dto.BuildingDTO;

public class BuildingMapper implements RowMapper<BuildingDTO> {

	@Override
	public BuildingDTO mapRow(ResultSet rs) {

		try {
			BuildingDTO buildingModel = new BuildingDTO();
			buildingModel.setName(rs.getString("name"));
			buildingModel.setStreet(rs.getString("street"));
			buildingModel.setStructure(rs.getString("structure"));
			buildingModel.setWard(rs.getString("ward"));
			buildingModel.setBuildingArea(rs.getInt("buildingarea"));
			buildingModel.setNumberOfBasement(rs.getInt("numberofbasement"));
			return buildingModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
