package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student_info")
public class StudentInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		long contact = Long.parseLong(req.getParameter("contact"));
		//String[] courses = req.getParameterValues("course"));
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("Id => " + id);
		writer.println("Email => " + email);
		writer.println("Name => " + name);
		writer.println("Age => " + age);
		writer.println("Contact" + contact);
		
//		for(int i = 0; i < courses.length; i++) {
//			writer.println(courses[i]);
//		}
		
	}
}
