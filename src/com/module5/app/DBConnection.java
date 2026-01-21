package com.module5.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {
	public static void main(String[] args) {
		final String URL = "jdbc:postgresql://localhost:5432/training_db";
	    final String USER = "postgres";
	    final String PASSWORD = "postgres";
	    
        Statement statement = null;
        ResultSet resultSet = null;
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to PostgreSQL successfully!");
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
}
