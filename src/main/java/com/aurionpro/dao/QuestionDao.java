package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.database.Connector;
import com.aurionpro.model.Question;

public class QuestionDao {
	Connection connection = Connector.getConnection();
	public Question getQuestionById(int id) {
        String sql = "SELECT * FROM questions WHERE question_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Question question = new Question();
                question.setQuestionId(rs.getInt("question_id"));
                question.setQuestionText(rs.getString("question_text"));
                question.setOptionA(rs.getString("option_a"));
                question.setOptionB(rs.getString("option_b"));
                question.setOptionC(rs.getString("option_c"));
                question.setOptionD(rs.getString("option_d"));
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null;
    }
	public int getTotalQuestions() {
	    String sql = "SELECT count(question_id) AS max_count FROM questions";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("max_count");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    return -1; 
	}
	public List<Question> getRandomQuestions(int count) {
	    List<Question> questions = new ArrayList<>();
	    String sql = "SELECT * FROM questions ORDER BY RANDOM() LIMIT ?";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setInt(1, count);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Question question = new Question();
	            question.setQuestionId(rs.getInt("question_id"));
	            question.setQuestionText(rs.getString("question_text"));
	            question.setOptionA(rs.getString("option_a"));
	            question.setOptionB(rs.getString("option_b"));
	            question.setOptionC(rs.getString("option_c"));
	            question.setOptionD(rs.getString("option_d"));
	            questions.add(question);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return questions;
	}
}
