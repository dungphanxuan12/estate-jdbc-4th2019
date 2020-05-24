package com.laptrinhwebrework.enums;

/**
 * 
 * @author Phan Xuan Dung
 *
 */
public enum BuildingTypes {

	TANG_TRET("Tầng Trệt"), 
	NGUYEN_CAN("Nguyên Căn"), 
	NOI_THAT("Nội Thất");

	private String value;

	private BuildingTypes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
