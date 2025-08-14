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
import com.aurionpro.service.AnswerService;


@WebServlet("/EvaluateAnswerController")
public class EvaluateAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnswerService answerService = new AnswerService();
   
    public EvaluateAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score = 0;
		HttpSession session = request.getSession(false);
		List<Answer> answers = (List<Answer>)session.getAttribute("Answers");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for(Answer answer:answers) {
			if(answerService.checkAnswer(answer)) {
				score++;
			}
		}
		
		out.print("<h1> your score : "+score+"</h1>");
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
