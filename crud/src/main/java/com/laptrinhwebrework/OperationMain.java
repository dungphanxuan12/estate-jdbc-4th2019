package com.laptrinhwebrework;

import java.util.List;

import com.laptrinhwebrework.jdbc.AbstractJDBC;
import com.laptrinhwebrework.mapper.BuildingMapper;
import com.laptrinhwebrework.model.Building;

public class OperationMain {

	public static void main(String[] args) {

		AbstractJDBC abstractJDBC = new AbstractJDBC();
		String sql = "SELECT * FROM building";
		List<Building> buildings = abstractJDBC.query(sql, new BuildingMapper());
		System.out.println(buildings.get(0).getName());
	}

}
