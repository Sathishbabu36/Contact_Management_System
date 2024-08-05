package com.practice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.config.DAOSingleton;
import com.practice.entity.Contact;
import com.practice.entity.User;


@WebServlet("/update_contact")
public class UpdateContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int contactId = Integer.parseInt(req.getParameter("contactId"));
		String contactName = req.getParameter("contactName");
		Long contactNumber = Long.parseLong(req.getParameter("contactNumber"));

		Contact contact = DAOSingleton.getContactDao().findContact(contactId);
		contact.setContactName(contactName);
		contact.setContactNum(contactNumber);


		boolean result = DAOSingleton.getContactDao().updateContact(contact);

		if (result) {
			HttpSession session = req.getSession();
			User user=(User)session.getAttribute("user");
			user = DAOSingleton.getuserDao().findUserByEmailAndPassword(user.getEmail(), user.getPassword());

			session.setAttribute("user", user);

			resp.sendRedirect("show_contact");
		}
	}
}
