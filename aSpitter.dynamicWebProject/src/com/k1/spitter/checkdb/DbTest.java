package com.k1.spitter.checkdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbTest {

	public static void main(String[] args) throws Exception {

		String jdbcUrl = "jdbc:mysql://localhost:3306/spitter?useSSL=false";
		String user = "root";
		String password = "123456";

		// we use BasicDataSource because it gives us ability to use pools of
		// connections
		// DriverManagerDataSource we not use because it returns just new
		// connection on every request
		// can'n gather requests to pool like BasicDataSource
		// SingleConnectionDataSource we not use because it returns same single
		// connection on every request
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		// A connection (session) with a specific database.
		// SQL statements are executed and results are returned within the
		// context of a connection.
		Connection connection = null;
		// A SQL statement is precompiled and stored in a PreparedStatement
		// object.
		// This object can then be used to efficiently execute this statement
		// multiple times.
		PreparedStatement prepared = null;

		try {
			System.out.println("Try connect to dataBase");
			// get connection
			connection = dataSource.getConnection();
			System.out.println("Success");

			// execute a simple query
			prepared = connection.prepareStatement("SELECT * FROM spitter");
			ResultSet result = prepared.executeQuery();

			while (result.next()) {
				System.out.println(
						"Result: " + result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
								+ result.getString(4) + " " + result.getString(5) + " " + result.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// if prepared statement available - close statement
			if (prepared != null) {
				prepared.close();
				// if connection available - close connection
				if (connection != null) {
					connection.close();
				}
			}
		}
	}
}

// package com.luv2code.jdbc;
//
// import java.sql.Connection;
// import java.sql.DriverManager;
//
//
//
// public class TestJdbc {
//
// public static void main(String[] args) {
// //download hibernate orm, put files from lib to lib in project
// //mysql.com/downloads -> connectors -> connector/j put jar to lib in project
//
// String jdbcUrl = "jdbc:mysql://localhost:3306/moviea?useSSL=false";
// String user = "root";
// String password = "123456";
//
// try{
// System.out.println("Connecting to database: " + jdbcUrl);
// Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
// System.out.println("Connection successful!");
// }
// catch(Exception e){
// e.printStackTrace();
// }
//
//// String jdbcUrl =
// "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
//// String user = "hbstudent";
//// String password = "hbstudent";
////
//// try{
//// System.out.println("Connecting to database: " + jdbcUrl);
//// Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
//// System.out.println("Connection successful!");
//// }
//// catch(Exception e){
//// e.printStackTrace();
//// }
// }
// }
