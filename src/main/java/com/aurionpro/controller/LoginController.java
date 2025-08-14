package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Answer;
import com.aurionpro.model.Question;
import com.aurionpro.service.QuestionService;
import com.aurionpro.service.UserService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private QuestionService questionService = new QuestionService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String password = request.getParameter("upassword");
		boolean isUser = userService.checkCredintails(name,password);
		if(isUser) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionOneController");
			List<Question> questions = this.questionService.getRandomQuestion(3);
			List<Answer> answers = new ArrayList<Answer>();
			HttpSession session = request.getSession();
			session.setAttribute("Questions", questions);
			session.setAttribute("Answers", answers);
            dispatcher.forward(request, response);
		}else {
			response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<p style='color:red;'>Invalid credentials</p>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            dispatcher.include(request, response);
		}
	}

}
