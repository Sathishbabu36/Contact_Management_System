package com.practice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.config.DAOSingleton;
import com.practice.entity.User;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		user.setUserId(userId);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);

		boolean result = DAOSingleton.getuserDao().updateUser(user);
		if(result) 
			req.setAttribute("success", "updated successfully!");
		else
			req.setAttribute("failure", "failed to update");
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
}
