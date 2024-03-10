package com.jspiders.cardekhowithservlets.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlets.jdbc.CarJDBC;

@WebServlet ("/addCar")
public class AddCar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		Long price = Long.parseLong(req.getParameter("price"));
				
		int res = CarJDBC.addCar(id, name, brand, price);
		
		if(res == 1) {
			req.setAttribute("message", "car added");
		}
		else
			req.setAttribute("message", "not added");
		
		RequestDispatcher request = req.getRequestDispatcher("add_car.jsp");
		request.forward(req, resp);
		
	}
}
