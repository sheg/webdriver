package com.webdriver.qa.automation.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.webdriver.qa.automation.framework.Framework;

public class DatabaseConnection {

	private Connection conn = null;
	
	public Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
		String url = Framework.databaseConfig.getDataBaseConfigAttributes().get("serverUrl");
		String databaseName = Framework.databaseConfig.getDataBaseConfigAttributes().get("databaseName");
		String username = Framework.databaseConfig.getDataBaseConfigAttributes().get("username");
		String password = Framework.databaseConfig.getDataBaseConfigAttributes().get("password");
				
		String connectionUrl = "jdbc:sqlserver://" + url + ";databaseName=" + databaseName +";user=" + username +";password=" + password + ";";
		if(conn == null) {
			conn = DriverManager.getConnection(connectionUrl);			
		}
		return conn;
	}

	public ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
		ResultSet resultSet = null;
		Connection conn = getDatabaseConnection();
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(query);

		return resultSet;
	}
}