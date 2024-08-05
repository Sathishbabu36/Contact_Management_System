package com.practice.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.config.DAOSingleton;
import com.practice.entity.Contact;
import com.practice.entity.User;


@WebServlet("/show_contact")
public class ShowContact extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		List<Contact> contacts =user.getContacts();
         
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("/show_contact.jsp").forward(req, resp);
	}
}
