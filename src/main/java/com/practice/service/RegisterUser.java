package com.practice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.config.DAOSingleton;
import com.practice.dao.UserDao;
import com.practice.entity.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);

		boolean result = DAOSingleton.getuserDao().saveUser(user);
		if(result)
			resp.sendRedirect("login.jsp");
	}
}
