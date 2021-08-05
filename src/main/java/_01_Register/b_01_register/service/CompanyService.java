package _01_Register.b_01_register.service;

import java.util.List;
import _01_Register.b_01_register.modal.CompanyBean;


public interface CompanyService {
	
	void save(CompanyBean companyBean);
	
	boolean existsByAccount(String account);
	
	CompanyBean findByCompanyAccount(String company_account);
	
	CompanyBean findByCompanyAccountAndPassword(String company_account, String password);
	
	void updateCompany(CompanyBean companyBean);
	
	void persist(CompanyBean companyBean);
	
	
	
	

	List<CompanyBean> findAll() ;

	CompanyBean findById(Integer id) ;

//	String getSelectTag(String tagName, int selected);
	
}