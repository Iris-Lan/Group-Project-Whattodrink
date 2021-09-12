package _01_Register.c_01_register.service;

import _01_Register.c_01_register.model.CustomerBean;

public interface CustomerService {

	void save(CustomerBean customerBean);

	boolean existsByCustomerAccount(String customer_account);
	
	CustomerBean findByCustomerId(int customer_id);

	CustomerBean findByCustomerAccount(String customer_account);

	CustomerBean findByCustomerAccountAndPassword(String customer_account, String customer_password);

	CustomerBean findByCustomerVerification(String customer_account, String customer_verification);

	void updateCustomer(CustomerBean customerBean);

	boolean existsByCustomerEmail(String email);

	boolean checkInvited(String customer_account);
	
	
	public boolean existsByInvitation(String invitation);
	
	public CustomerBean findByInvitation(String invitation);
	
	public void updateCustomers(CustomerBean... customerBean);



}