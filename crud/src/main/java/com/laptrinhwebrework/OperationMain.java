package com.laptrinhwebrework;

import java.util.List;

import com.laptrinhwebrework.dto.BuildingDTO;
import com.laptrinhwebrework.entity.BuildingEntity;
import com.laptrinhwebrework.jdbc.AbstractJDBC;

public class OperationMain {

	public static void main(String[] args) {
		AbstractJDBC<BuildingDTO> abstractJDBC = new AbstractJDBC<BuildingDTO>();
		String sql = "SELECT * FROM building";
		List<BuildingEntity> buildings = abstractJDBC.query(sql, BuildingEntity.class);
		System.out.println(".............");
	}

}
