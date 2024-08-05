package com.practice.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.practice.config.DAOSingleton;
import com.practice.entity.Contact;
import com.practice.entity.User;

@WebServlet("/delete_contact")
public class DeleteContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("user");

		int contactId =Integer.parseInt(req.getParameter("contactId"));

		List<Contact> contacts = user.getContacts();
		for (Contact contact : contacts) {
			if (contact.getContactId()==contactId) {
				contacts.remove(contact);
				break;
			}
		}
		user.setContacts(contacts);
		DAOSingleton.getuserDao().updateUser(user);

		boolean result = DAOSingleton.getContactDao().deleteContact(contactId);

		User user2 = DAOSingleton.getuserDao().findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		session.setAttribute("user", user2);
		
		if(result)
			resp.sendRedirect("index.jsp");
	}
}
