package com.samples.jdbc;

import java.util.List;

public class JDBCExercise {

	public JDBCExercise() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		CustomerSpecificationByNumber cSpecByNum = new CustomerSpecificationByNumber();
		cSpecByNum.customerNumber = 347;
			
		CustomerRepository crsql = new CustomerSqlRepository();
		List customerList = crsql.query(cSpecByNum);

		String s = "";

		
	}

}
