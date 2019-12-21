package com.laptrinhweb.repository.impl;

import com.laptrinhweb.entity.RentArea;
import com.laptrinhweb.repository.IRentAreaRepository;

public class RentAreaRepository extends AbstractJDBC<RentArea> implements IRentAreaRepository{

	@Override
	public void deleteByBuilding(Long id) {
		String where = "WHERE buildingid = "+id+" ";
		this.deleteByProperty(where);
	}

}
