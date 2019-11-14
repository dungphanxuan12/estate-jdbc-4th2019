package com.laptrinhweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin-building" })
public class BuildingController extends HttpServlet {

	private static final long serialVersionUID = 5093139813922059839L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";
		String action = request.getParameter("action");

		if ("LIST".equals(action)) {
			path = "/views/admin/building/listBuildings.jsp";
		} else if ("EDIT".equals(action)) {
			path = "/views/admin/building/edit_building.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
