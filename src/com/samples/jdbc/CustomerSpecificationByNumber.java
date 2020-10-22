package com.samples.jdbc;

public class CustomerSpecificationByNumber implements CustomerSpecification {

	public int customerNumber;
	
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public CustomerSpecificationByNumber() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toSql() {
		// TODO Auto-generated method stub
		return "SELECT * FROM mydb.customer where customerNumber = " + this.customerNumber;
	}

}
