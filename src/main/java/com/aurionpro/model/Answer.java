package com.aurionpro.model;

public class Answer {
	private int anserwerId;
	private int questionId;
	private String correctOption;
	public int getAnserwerId() {
		return anserwerId;
	}
	public void setAnserwerId(int anserwerId) {
		this.anserwerId = anserwerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public Answer() {
		
	}
	
}
