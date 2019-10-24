package com.laptrinhweb.jdbc;

import java.util.List;

import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.model.BuildingModel;

public class OperationMain {

	public static void main(String[] args) {

		AbstractJDBC<BuildingModel> abstractJDBC = new AbstractJDBC<>();

		// String sql = "UPDATE building SET name = ?, ward = ?, street = ? WHERE id =
		// ?";
		// abstractJDBC.update(sql, "Tòa Nhà Update", "Phú Mỹ Hưng", "ABC", 1);

		// String sql2 = "INSERT INTO building (name, ward, street, structure,
		// numberOfBasement, buildingArea) VALUES (?, ?, ?, ?, ?, ?)";
		// System.out.println(abstractJDBC.insert(sql2, "thêm", "Quận", "Trần Duy Hưng",
		// "???", 10, 1000));

		// String sql3 = "DELETE FROM building WHERE id = ?";
		// abstractJDBC.update(sql3, 7);

		String sql4 = "SELECT * FROM building";
//		List<BuildingModel> results = abstractJDBC.query(sql4, new BuildingMapper());
		List<BuildingEntity> results = abstractJDBC.query(sql4, BuildingEntity.class);
		for (BuildingEntity buildingEntity : results) {
			System.out.println(buildingEntity.getName());
		}

	}
}
