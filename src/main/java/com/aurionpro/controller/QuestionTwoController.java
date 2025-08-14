package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Answer;
import com.aurionpro.model.Question;


@WebServlet("/QuestionTwoController")
public class QuestionTwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<Question> questions = (List<Question>)session.getAttribute("Questions");
		Question question = questions.get(1);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<title>Question</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body class='bg-light'>");

		out.println("<div class='container d-flex justify-content-center align-items-center vh-100'>");
		out.println("<div class='card shadow-sm p-4' style='max-width: 600px; width: 100%;'>");

		out.println("<form action='QuestionThreeController' method='post'>");

		out.println("<h4 class='mb-4'>" + question.getQuestionText() + "</h4>");
		out.println("<input type='hidden' name='questionId' value='" + question.getQuestionId() + "'>");

		// Option A
		out.println("<div class='form-check mb-2'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionA' value='A' required>");
		out.println("<label class='form-check-label' for='optionA'>" + question.getOptionA() + "</label>");
		out.println("</div>");

		// Option B
		out.println("<div class='form-check mb-2'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionB' value='B'>");
		out.println("<label class='form-check-label' for='optionB'>" + question.getOptionB() + "</label>");
		out.println("</div>");

		// Option C
		out.println("<div class='form-check mb-2'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionC' value='C'>");
		out.println("<label class='form-check-label' for='optionC'>" + question.getOptionC() + "</label>");
		out.println("</div>");

		// Option D
		out.println("<div class='form-check mb-3'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionD' value='D'>");
		out.println("<label class='form-check-label' for='optionD'>" + question.getOptionD() + "</label>");
		out.println("</div>");

		out.println("<button type='submit' class='btn btn-primary w-100'>Next</button>");

		out.println("</form>");
		out.println("</div>"); // card
		out.println("</div>"); // container
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<Answer> answers = (List<Answer>)session.getAttribute("Answers");
		Answer answer = new Answer();
		answer.setQuestionId(Integer.valueOf(request.getParameter("questionId")));
		answer.setCorrectOption(request.getParameter("answer"));
		answers.add(answer);
		session.setAttribute("Answers", answers);
		doGet(request, response);
	}

}
