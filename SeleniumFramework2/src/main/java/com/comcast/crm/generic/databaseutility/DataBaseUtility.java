package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

    private Connection con = null;

    /**
     * Establish database connection
     */
    public void getDBConnection(String url, String username, String password) throws SQLException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        con = DriverManager.getConnection(url, username, password);

        System.out.println("Database Connected Successfully");
    }

    /**
     * Close database connection
     */
    public void closeDBConnection() {

        try {
            if (con != null) {
                con.close();
                System.out.println("Database Closed Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute SELECT Query
     */
    public ResultSet executeSelectQuery(String query) throws SQLException {

        Statement stat = con.createStatement();

        ResultSet result = stat.executeQuery(query);

        return result;
    }

    /**
     * Execute INSERT, UPDATE, DELETE Query
     */
    public int executeNonSelectQuery(String query) throws SQLException {

        Statement stat = con.createStatement();

        int result = stat.executeUpdate(query);

        return result;
    }

	public void getDBConnection() {
		// TODO Auto-generated method stub
		
	}
}