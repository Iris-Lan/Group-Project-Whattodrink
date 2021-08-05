package _01_Register.b_01_register.main;

import java.util.List;

import _01_Register.b_01_register.modal.CompanyBean;
import _01_Register.b_01_register.service.CompanyService;
import _01_Register.b_01_register.service.serviceImpl.CompanyServiceImpl;


public class TestOK_MethodsOfCompanyDao {
	public static void main(String[] args) {

//updateCompany()
		CompanyService companyService = new CompanyServiceImpl();
		
		CompanyBean cb = new CompanyBean();
		cb = companyService.findByCompanyAccount("dog1111");
		cb.setCompany_owner("我原本叫黃小新，被改成黃大新了");
		companyService.updateCompany(cb);
		
		System.out.println(companyService.findById(5));
		
		
		
//existsByAccount()
//		System.out.println(companyService.existsByAccount("kitty1111"));
		
		
//findByCompanyAccountAndPassword()  => 例子為密碼錯誤，改0000
//		System.out.println(companyService.findByCompanyAccountAndPassword("kitty1111", "0001"));
		
		
//findByCompanyAccount()
//		System.out.println(companyService.findByCompanyAccount("kitty1111"));
				
//findById()
//		CompanyBean companyBean = companyService.findById(1);
//		System.out.println(companyBean);
		
//findAll()
//		List<CompanyBean> list = companyService.findAll();
//		for(CompanyBean company : list) {
//			System.out.println(company);
//		}

	}

}
