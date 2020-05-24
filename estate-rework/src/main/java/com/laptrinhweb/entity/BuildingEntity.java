package com.laptrinhweb.entity;

import com.laptrinhweb.anotations.Column;
import com.laptrinhweb.anotations.Entity;

@Entity
public class BuildingEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "ward")
	private String ward;

	@Column(name = "street")
	private String street;

	@Column(name = "structure")
	private String structure;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

	@Column(name = "buildingarea")
	private Integer buildingArea;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}

}
