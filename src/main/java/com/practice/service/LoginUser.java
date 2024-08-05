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

@WebServlet("/login")
public class LoginUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = null;
		try {
			user = DAOSingleton.getuserDao().findUserByEmailAndPassword(email, password);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		if(user !=null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		}
		else {
			req.setAttribute("error", "Email or Password is incorrect!!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
