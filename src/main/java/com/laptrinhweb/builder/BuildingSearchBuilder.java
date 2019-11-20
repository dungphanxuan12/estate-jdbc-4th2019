package com.laptrinhweb.builder;

public class BuildingSearchBuilder {

	private String name;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private Integer costRentFrom;
	private Integer costRentTo;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private String[] buildingTypes = new String[] {};

	public String getName() {
		return name;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getCostRentFrom() {
		return costRentFrom;
	}

	public Integer getCostRentTo() {
		return costRentTo;
	}

	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}

	public Integer getRentAreaTo() {
		return rentAreaTo;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public BuildingSearchBuilder(Builder builder) {
		super();
		this.name = builder.name;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.costRentFrom = builder.costRentFrom;
		this.costRentTo = builder.costRentTo;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.buildingTypes = builder.buildingTypes;
	}

	public static class Builder {

		private String name;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private Integer costRentFrom;
		private Integer costRentTo;
		private Integer rentAreaFrom;
		private Integer rentAreaTo;
		private String[] buildingTypes = new String[] {};

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setCostRentFrom(Integer costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Builder setCostRentTo(Integer costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Builder setRentAreaFrom(Integer rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}

		public Builder setRentAreaTo(Integer rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}

		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}

}
