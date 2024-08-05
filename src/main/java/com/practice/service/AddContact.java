package com.practice.service;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/addContact")
public class AddContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");

		String contactName = req.getParameter("contactName");
		long contactNumber = Long.parseLong(req.getParameter("contactNumber"));

		Contact contact = new Contact();
		contact.setContactName(contactName);
		contact.setContactNum(contactNumber);
		contact.setUser(user);

		List<Contact> contacts = user.getContacts();
		contacts.add(contact);
		user.setContacts(contacts);

		//boolean resultUser = DAOSingleton.getuserDao().updateUser(user);
		boolean resultContact = DAOSingleton.getContactDao().saveContact(contact);

		if( resultContact) {
			req.setAttribute("success", "contact added successcully");
		    req.getRequestDispatcher("addcontact.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("failure", "failed to add contact");
			req.getRequestDispatcher("addcontact.jsp").forward(req, resp);
		}
	}
}
