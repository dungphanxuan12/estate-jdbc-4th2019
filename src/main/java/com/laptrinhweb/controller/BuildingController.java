package com.laptrinhweb.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.IBuildingService;
import com.laptrinhweb.utils.DataUtils;
import com.laptrinhweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-building" })
public class BuildingController extends HttpServlet {

	private static final long serialVersionUID = 5093139813922059839L;

	@Inject
	private IBuildingService buildingService;

//	public BuildingController() {
//		if(buildingService == null) {
//			buildingService = new BuildingService();
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BuildingDTO buildingDTO = FormUtil.toModel(BuildingDTO.class, request);
		String path = "";
		String action = request.getParameter("action");

		if ("LIST".equals(action)) {
			BuildingSearchBuilder builder = initBuildingBuilder(buildingDTO);
			Pageble pageble = new PageRequest(null, null, null);
			buildingDTO.setListResults(buildingService.findAll(builder, pageble));
			path = "/views/admin/building/listBuildings.jsp";

		} else if ("EDIT".equals(action)) {
			if (buildingDTO.getId() != null) {
				buildingDTO = buildingService.findById(buildingDTO.getId());
			}
			path = "/views/admin/building/edit_building.jsp";
		}

		request.setAttribute("buildingModel", buildingDTO);
		request.setAttribute("districts", DataUtils.getDistricts());
		request.setAttribute("buildingTypes", DataUtils.getBuildingTypes());
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	private BuildingSearchBuilder initBuildingBuilder(BuildingDTO buildingDTO) {
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder().setName(buildingDTO.getName())
				.setWard(buildingDTO.getWard()).setStreet(buildingDTO.getStreet())
				.setRentAreaFrom(buildingDTO.getRentAreaFrom()).setRentAreaTo(buildingDTO.getRentAreaTo())
				.setCostRentFrom(buildingDTO.getCostRentFrom()).setCostRentTo(buildingDTO.getCostRentTo())
				.setBuildingTypes(buildingDTO.getBuildingTypes()).build();
		return builder;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		
	}

}
