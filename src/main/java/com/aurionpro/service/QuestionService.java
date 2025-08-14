package com.aurionpro.service;

import java.util.List;

import com.aurionpro.dao.QuestionDao;
import com.aurionpro.model.Question;

public class QuestionService {
	QuestionDao questionDao = new QuestionDao();
	public List<Question> getRandomQuestion(int count){
		return questionDao.getRandomQuestions(count);
	}
}
