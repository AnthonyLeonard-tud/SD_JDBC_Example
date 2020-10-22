package com.samples.jdbc;

import java.util.List;

public interface CustomerRepository {
	void addCustomer(Customer customer);
	void removeCustomer (Customer customer);
	List query(CustomerSpecification specification);
}
