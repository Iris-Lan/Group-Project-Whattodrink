package _01_Register.b_01_register.dao;

import java.util.List;

import _01_Register.b_01_register.modal.CompanyBean;


public interface CompanyDao {
	
	void save(CompanyBean companyBean);
	
	boolean existsByAccount(String account);
	
	CompanyBean findByCompanyAccount(String company_account);
	
	void updateCompany(CompanyBean companyBean);
	
	CompanyBean findByCompanyAccountAndPassword(String company_account, String password);
	
	void persist(CompanyBean companyBean);
	
	
	

	List<CompanyBean> findAll();

	CompanyBean findById(Integer id);

	

}