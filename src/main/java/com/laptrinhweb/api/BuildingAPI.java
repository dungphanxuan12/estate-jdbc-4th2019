package com.laptrinhweb.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.service.IBuildingService;
import com.laptrinhweb.service.impl.BuildingService;
import com.laptrinhweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-building" })
public class BuildingAPI extends HttpServlet {

	private static final long serialVersionUID = -8514820519252702095L;

	private IBuildingService buildingService;

	public BuildingAPI() {
		buildingService = new BuildingService();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingDTO = buildingService.save(buildingDTO);
		mapper.writeValue(resp.getOutputStream(), buildingDTO);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.update(buildingDTO,buildingDTO.getId());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		buildingService.delete(buildingDTO.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
