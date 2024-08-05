package com.practice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.config.DAOSingleton;
import com.practice.entity.Contact;


@WebServlet("/load_contact")
public class LoadContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId = Integer.parseInt(req.getParameter("contactId"));
		Contact contact = DAOSingleton.getContactDao().findContact(contactId);
		req.setAttribute("contact", contact);
		req.getRequestDispatcher("/edit_contact.jsp").forward(req, resp);
	}
}
