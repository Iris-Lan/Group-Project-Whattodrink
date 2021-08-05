package _00_init.utils;
import java.sql.Date;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _01_Register.b_01_register.dao.impl.CompanyDaoImpl;
import _01_Register.b_01_register.modal.CompanyBean;
import _01_Register.b_01_register.service.CompanyService;
import _01_Register.b_01_register.service.serviceImpl.CompanyServiceImpl;

public class CreateTable_company {
	public static void main(String[] args) {

		
		String 	company_name = 			"清心";
		String 	company_account = 		"dog1111";	
		String 	company_password = 		"0000";
		String 	company_owner = 		"黃小新";
		String 	company_owner_email = 	"dd@ee.ff";
		Time 	start_time = 			Time.valueOf("9:00:00");
		Time 	end_time = 				Time.valueOf("22:00:00");	
		String 	tel = 					"0967389292";
		String 	company_address = 		"台北市中山區";
		String 	website = 				"https://www.google.com/";
		String 	company_iconpath = 		"./images/company3.jpg";
		String 	company_filename = 		"company3.jpg";
		String 	tax_id_number = 		"66666666";
		Timestamp register_date = 		new Timestamp(System.currentTimeMillis());
		Timestamp alter_date = 			new Timestamp(System.currentTimeMillis());
		
		CompanyBean companyBean = new CompanyBean
				(null, company_name, company_account, company_password, company_owner, 
				 company_owner_email, start_time, end_time, tel, company_address, 
				 website, company_iconpath, company_filename, tax_id_number, register_date, alter_date);
				
		
		CompanyService companyService = new CompanyServiceImpl();
		companyService.persist(companyBean);
	}
}
