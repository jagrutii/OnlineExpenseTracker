package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		String about = req.getParameter("about");
		
		User u = new User( name, email, password, about);
		
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		boolean f = dao.saveUser(u);
		
		HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("msg", "Registered Successfuly");
			//System.out.println("Registered Successfuly");
			
		} else {
			session.setAttribute("msg", "Something went Wrong");
			//System.out.println("Something went Wrong");
			
		}
		resp.sendRedirect("register.jsp");
	}

	
}
