package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.database.Connector;
import com.aurionpro.model.Answer;

public class AnswerDao {
	Connection connection = Connector.getConnection();
	public boolean checkAnswer(Answer answer) {
		String sql = "select count(*) from answers where question_id = ? and correct_option = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1,answer.getQuestionId());
			preparedStatement.setString(2, answer.getCorrectOption());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
                } 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
