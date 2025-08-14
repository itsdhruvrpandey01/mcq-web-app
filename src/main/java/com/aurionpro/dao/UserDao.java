package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.database.Connector;

public class UserDao {
	Connection connection = Connector.getConnection();
	public boolean checkCredintails(String uname,String upassword) {
		String sql = "Select count(*) from users where name = ? and password = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2,upassword);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
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
