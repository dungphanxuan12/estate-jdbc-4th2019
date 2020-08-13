package com.laptrinhweb.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author dung phan
 *
 */
@Setter
@Getter
public class BuildingDTO extends AbstractDTO<BuildingDTO> {

	@NotNull(message = "An building name cannot be null")
	private String name;
	private String ward;
	private String street;
	private String structure;
	private Integer numberOfBasement;

	@NotNull(message = "An building name cannot be null")
	private Integer buildingArea;

	@NotNull(message = "An costRent cannot be null")
	private Integer costRent;
	private String costDescription;
	private String district;
	private String serviceCost;
	private String carCost;
	private String motobikeCost;
	private String overtimeCost;
	private String electricityCost;
	private String deposit;
	private String payment;
	private String timeRent;
	private String timeDecorator;
	private String managerName;
	private String managerPhone;
	private String costRentFrom;
	private String costRentTo;
	private String rentAreaFrom;
	private String rentAreaTo;
	private String type;
	private String direction;
	private String level;
	private String rentArea;
	private String[] buildingTypes = new String[] {};

}