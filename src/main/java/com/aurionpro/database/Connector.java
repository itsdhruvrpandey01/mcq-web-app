package com.aurionpro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static Connection connection = null;
	private Connector() {
		
	}
	public static Connection getConnection() {
		if(connection==null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres",
						"Dhruv123");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}

