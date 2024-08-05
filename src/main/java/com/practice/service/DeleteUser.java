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

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		session.invalidate();
		boolean result = DAOSingleton.getuserDao().deleteUser(user.getUserId());

		if(result)
			req.setAttribute("success", "Deleted Successfully!");
		else
			req.setAttribute("failure", "failed to delete !");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
