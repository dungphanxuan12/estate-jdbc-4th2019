package com.laptrinhwebrework.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebrework.model.Building;

/**
 * The BuildingMapper Class implements a Rowmapper Interface
 * 
 *
 * @author Dung Phan Xuan
 * @version 1.0
 * @since 2020-05-14
 */
public class BuildingMapper implements Rowmapper<Building> {

	@Override
	public Building maprow(ResultSet resultSet) {

		try {
			Building building = new Building();
			String name = resultSet.getString("name");
			building.setName(name);
			return building;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
