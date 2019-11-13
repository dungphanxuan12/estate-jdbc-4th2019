package com.laptrinhweb.entity;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Entity;
import com.laptrinhweb.annotation.Table;

@Entity
@Table(name = "rentarea")
public class RentArea extends BaseEntity {

	@Column(name = "value")
	private String value;

	@Column(name = "buildingid")
	private Long buildingid;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

}
