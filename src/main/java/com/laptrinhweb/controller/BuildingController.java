package com.laptrinhweb.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

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

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@WebServlet(urlPatterns = { "/admin-building" })
public class BuildingController extends HttpServlet {

	private static final long serialVersionUID = 5093139813922059839L;

	@Inject
	private IBuildingService buildingService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BuildingDTO buildingDTO = FormUtil.toModel(BuildingDTO.class, request);
		String path = "";
		String action = request.getParameter("action");

		if ("LIST".equals(action)) {
			BuildingSearchBuilder builder = initBuildingBuilder(buildingDTO);
			Pageble pageble = new PageRequest(buildingDTO.getPage(), buildingDTO.getMaxPageItem(), null);
			buildingDTO.setTotalItem(buildingService.getTotalItem(builder));
			buildingDTO.setTotalPage((int) Math.ceil((buildingDTO.getTotalItem() / buildingDTO.getMaxPageItem())));
			buildingDTO.setListResults(buildingService.findAll(builder, pageble));
			path = "/views/admin/building/listBuildings.jsp";
			request.setAttribute("titleReq", "Danh sách tòa nhà ");

			DefaultHttpClient httpClient = new DefaultHttpClient();
			StringBuilder url = new StringBuilder("http://localhost:8081/api/building");
			url.append("?page=" + buildingDTO.getPage() + "&maxPageItem=" + buildingDTO.getMaxPageItem() + "");

			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();

			for (Field field : fields) {
				try {
					if (field.get(builder) != null) {
						if (field.getName().equals("buildingTypes")) {
							String[] buildingTypes = (String[]) field.get(builder);
							for (String buildingType : buildingTypes) {
								url.append("&buildingTypes" + "=" + buildingType + "");
							}
						} else {
							url.append("&" + field.getName() + "=" + field.get(builder) + "");
						}

					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

			}

//			if(StringUtils.isNotBlank(buildingDTO.getSortName())){
//				url.append("&sortBy="+buildingDTO.getSortBy+"&sortName"+buildingDTO.getSortName()+"");
//			}

			HttpGet getRequest = new HttpGet(url.toString());
			HttpResponse httpResponse = httpClient.execute(getRequest);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			String result = "";
			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity);
			}
			List<BuildingDTO> buildingsAPI = null;
			request.setAttribute("buildingsAPI", buildingsAPI);

		} else if ("EDIT".equals(action)) {
			if (buildingDTO.getId() != null) {
				buildingDTO = buildingService.findById(buildingDTO.getId());
			}
			path = "/views/admin/building/edit_building.jsp";
			request.setAttribute("titleReq", "Thêm tòa nhà ");
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
