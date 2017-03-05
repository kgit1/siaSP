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
// Example of using BasicDataSource in java
// In short, to create a simple BasicDataSource object you should:
// Create a BasicDataSource object and configure the database. Use
// setDriverClassName(String driverClassName) method to set the jdbc driver
// class name. Use setUrl(String url) method to set the url. Use
// setUsername(String username) and setPassword(String password) to set the
// username and the password.
// Use the getConnection() method of BasicDataSource to get the Connection for
// the database.
// Use the prepareStatement(String sql) API method of Connection to create a
// PreparedStatement object for sending parameterized SQL statements to the
// database.
// Use executeQuery() API method of PreparedStatement to execute the SQL query
// in this PreparedStatement object and return the ResultSet object generated by
// the query. Print the values of the ResultSet.
// Close both the Connection and the PreparedStatement.

// BasicDataSource Constructors
// BasicDataSource only supports default constructor
// BasicDataSource()
// 2. BasicDataSource common methods
// Following are some commonly used methods from BasicDataSource
// void close()
// This method closes all idle connections stored in connection pool.
// Connection getConnection()
// Returns a connection to the database. This connection will be further
// utilised for interacting with underlying database.
// int getInitialSize()
// This method returns initial size of created connection pool.
// int getMaxActive()
// This method returns maximum number of active connections that can be
// allocated at same time.
// int getMaxIdle()
// This method returns maximum number of connections that can lie idle in the
// connection pool.
// int getNumIdle()
// This method returns number of idle connections in the pool.
// int getNumActive
// This method returns number of active connections in the pool.
// void setUrl(String url)
// This method sets the url from where database is to be accessed.
// void setDriverClassName(String driverClassName)
// This method sets the className for database driver. This method must be used
// before connection pool initialization.
// void setUsername(String username)
// This method sets the user name to be used for accessing underlying database.
// void setPassword(String password)
// This method sets the password to be used for accessing underlying database.

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import org.apache.commons.dbcp.BasicDataSource;
// public class BasicDataSourceExample {
//
// public static void main(String args[]) throws SQLException {
// BasicDataSource dataSource = new BasicDataSource();
// dataSource.setDriverClassName("org.sqlite.JDBC");
// dataSource.setUrl("jdbc:sqlite:test.db");
// createTable(dataSource);
// insertQuery(dataSource);
// selectQuery(dataSource);
// dropTable(dataSource);
// }
//
// private static void insertQuery(BasicDataSource dataSource) throws
// SQLException {
// Statement stmt = dataSource.getConnection().createStatement();
// String sql = "INSERT INTO Users VALUES('1','tom','chasing jerry')";
// stmt.executeUpdate(sql);
// sql = "INSERT INTO Users VALUES('2','jerry','eating chesse')";
// stmt.executeUpdate(sql);
// stmt.close();
// }
//
// private static void dropTable(BasicDataSource dataSource)
// throws SQLException {
// Statement stmt = dataSource.getConnection().createStatement();
// String sql = "DROP TABLE Users";
// stmt.executeUpdate(sql);
// stmt.close();
// System.out.println("Table dropped");
// }
//
// private static void createTable(BasicDataSource dataSource)
// throws SQLException {
// Statement stmt = dataSource.getConnection().createStatement();
// String sql = "CREATE TABLE 'Users' ('id' TEXT,'name' TEXT,'passion'
// TEXT,PRIMARY KEY(id));";
// stmt.executeUpdate(sql);
// stmt.close();
// System.out.println("Table created");
// }
//
// private static void selectQuery(BasicDataSource dataSource)
// throws SQLException {
// Connection connection = null;
// PreparedStatement statement = null;
// System.out.println("*********************Selecting
// data************************");
// System.out.println();
// try {
// connection = dataSource.getConnection();
// statement = connection.prepareStatement("SELECT * FROM Users");
// ResultSet rs = statement.executeQuery();
// while (rs.next()) {
// String s = String.format("ID:%s Username:%s Passion:%s",
// rs.getString("id"), rs.getString("name"),
// rs.getString("passion"));
// System.out.println(s);
// System.out.println();
// }
// System.out.println("");
// System.out.println("*******************************************************");
// } catch (Exception e) {
// System.out.println(e.getMessage());
// } finally {
// if (statement != null)
// statement.close();
// if (connection != null)
// connection.close();
// }
// }
// }

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
