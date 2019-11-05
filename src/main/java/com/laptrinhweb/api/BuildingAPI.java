package com.laptrinhweb.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-building" })
public class BuildingAPI extends HttpServlet {

	private static final long serialVersionUID = -8514820519252702095L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		// logic
		mapper.writeValue(response.getOutputStream(), buildingDTO);
	}

}
 