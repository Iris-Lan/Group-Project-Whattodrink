package _00_init.utils;
import java.sql.Date;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _01_Register.b_01_register.dao.impl.CompanyDaoImpl;
import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.b_01_register.service.CompanyService;
import _01_Register.b_01_register.service.serviceImpl.CompanyServiceImpl;

public class CreateTable_company {
	public static void main(String[] args) {

		CompanyService companyService = new CompanyServiceImpl();
		
		String 	company_name = 			"萬波";
		String  company_id = 			companyService.getCompanyId(company_name);
		String 	company_account = 		"cat3333";	
		String 	company_password = 		"0000";
		String 	company_owner = 		"張三三";
		String 	company_owner_email = 	"33@bb.cc";
		Time 	start_time = 			Time.valueOf("9:00:00");
		Time 	end_time = 				Time.valueOf("22:00:00");	
		String 	tel = 					"0933333333";
		String 	company_address = 		"台北市中山區";
		String 	website = 				"https://www.google.com/";
		String 	company_iconpath = 		"./images/company3.jpg";
		String 	company_filename = 		"company3.jpg";
		String 	tax_id_number = 		"33333333";
		Timestamp register_date = 		new Timestamp(System.currentTimeMillis());
		Timestamp alter_date = 			new Timestamp(System.currentTimeMillis());
		String 	company_owner_phone = 	"0933333333"; 					//負責人電話
		String 	trade_name = 			"可不可有限公司";  					//公司行號
		String 	bg_iconpath = 			"./images/company3_bg.jpg";		//底圖
		String 	bg_filename = 			"company3_bg.jpg";
		
		CompanyBean companyBean = new CompanyBean
				(company_id, company_name, company_account, company_password, company_owner, 
				 company_owner_email, start_time, end_time, tel, company_address, 
				 website, company_iconpath, company_filename, tax_id_number, register_date, alter_date,
				 company_owner_phone,trade_name,bg_iconpath,bg_filename);

		companyBean.setDrinks(null);
		companyBean.setCategories(null);
		companyBean.setToppings(null);
//		companyBean.setOrders(null);
		companyBean.setFavorites(null);
		
		
		companyService.save(companyBean);
	}
}
