package _01_Register.c_01_register.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _01_Register.c_01_register.service.CustomerService;
import _01_Register.c_01_register.service.serviceImpl.CustomerServiceImpl;



/*
 * 本程式: 
 * V(1) 讀取瀏覽器前端網頁傳送來的輸入資料，
 * X(2) 對資料進行必要的型態轉換，
 * V(3) 檢查使用者輸入資料，
 * V(4) 呼叫Service元件，進行企業邏輯運算，
 * X(5) 依照Logic運算結果送回適當的畫面給前端的使用者。
 * 
 */


@WebServlet("/_01_register/register.do")
public class C_RegisterCheckServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(C_RegisterCheckServlet.class);	
	
	
		
	String customer_phone = "";
	String customer_email = "";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.info("會員註冊功能之Controller: 開始");		
		request.setCharacterEncoding("UTF-8");
		
		// 讀取使用者輸入資料
		customer_phone = request.getParameter("userPhone_login");
		customer_email = request.getParameter("password_login");
		

		
		// 檢查使用者輸入資料：交由前端

		// 產生CustomerDao物件，以便進行企業邏輯運算。
		CustomerService customerService = new CustomerServiceImpl();
		
		
			
		if (!(customerService.existsByCustomerAccount(customer_phone)) && !(customerService.existsByCustomerEmail(customer_email)) ){
			log.info("顧客會員註冊功能之檢查結果： 手機號碼合格、email合格 ");
			// 之後補寄送mail功能
			response.getWriter().write("1");
			
		} else if (customerService.existsByCustomerAccount(customer_phone) && !(customerService.existsByCustomerEmail(customer_email))) {
			log.info("顧客會員註冊功能之檢查結果： 手機號碼不合格");
			response.getWriter().write("2");
						
		} else if (!(customerService.existsByCustomerAccount(customer_phone)) && customerService.existsByCustomerEmail(customer_email) ) {
			log.info("顧客會員註冊功能之檢查結果： email不合格");
			response.getWriter().write("3");
			
		} else {
			log.info("顧客會員註冊功能之檢查結果： 手機號碼不合格、email不合格");
			response.getWriter().write("4");
			
		}
		
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}