package com.samples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CustomerSqlRepository implements CustomerRepository  {

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public List query(CustomerSpecification specification) {
		List<Customer> listOfCustomers = new LinkedList();
		
		Statement stmt;
		try {
			Connection conn = this.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( specification.toSql() ) ;
			
			while( rs.next() )
			{
				Customer tempCustomer = new Customer();
				tempCustomer.setCustomerNumber(rs.getInt(1));
				tempCustomer.setCustomerName(rs.getString(2));
				tempCustomer.setContactLastName(rs.getString(3));
				tempCustomer.setContactFirstName(rs.getString(4));
				tempCustomer.setPhone(rs.getString(5));
				tempCustomer.setAddressLine1(rs.getString(6));
				tempCustomer.setAddressLine2(rs.getString(7));
				tempCustomer.setCity(rs.getString(8));
				tempCustomer.setState(rs.getString(9));
				tempCustomer.setPostalCode(rs.getString(10));
				tempCustomer.setCountry(rs.getString(11));
				tempCustomer.setSalesRepEmployeeNumber(rs.getInt(12));
				tempCustomer.setCreditLimit(rs.getDouble(13));
				listOfCustomers.add(tempCustomer);
			}
			
			rs.close();
			stmt.close();	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return listOfCustomers;
	}

	private Connection getConnection(){
		// Load the database driver
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" ) ;
			// Get a connection to the database
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT", "root", "password" ) ;

			return conn;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
