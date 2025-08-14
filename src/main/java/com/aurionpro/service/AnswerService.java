package com.aurionpro.service;

import com.aurionpro.dao.AnswerDao;
import com.aurionpro.model.Answer;

public class AnswerService {
	private AnswerDao answerDao = new AnswerDao();
	public boolean checkAnswer(Answer answer) {
		return this.answerDao.checkAnswer(answer);
	}
}
