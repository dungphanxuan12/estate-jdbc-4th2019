package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.BuildingModel;

public class BuildingMapper implements RowMapper<BuildingModel> {

	@Override
	public BuildingModel mapRow(ResultSet rs) {

		try {
			BuildingModel buildingModel = new BuildingModel();
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
