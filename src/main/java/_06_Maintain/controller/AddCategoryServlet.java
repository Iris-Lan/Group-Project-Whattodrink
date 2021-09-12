package _06_Maintain.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _01_Register.b_01_register.model.CompanyBean;
import _03_ListDrinks.model.CategoryBean;
import _03_ListDrinks.service.CategoryService;
import _03_ListDrinks.service.serviceImpl.CategoryServiceImpl;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(AddCategoryServlet.class);   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("企業用戶新增分類之Controller: 開始");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		CompanyBean companyBean = (CompanyBean) session.getAttribute("BLoginOK");
		String company_id = companyBean.getCompany_id();
		CategoryService categoryService = new CategoryServiceImpl();
		
		
//		for (int i = 0; i < 5; i++) {
//			String index = Integer.toString(i);
//			if (request.getParameter(("name" + index)).length() != 0) {
//				String category_name = request.getParameter(("name" + index));
//				CategoryBean categoryBean = new CategoryBean();
//				categoryBean.setCompany_id(company_id);
//				categoryBean.setCategory_name(category_name);
//				categoryBean.setCompanyBean(companyBean);
//				categoryService.save(categoryBean);
//			}
//		}
		
		if (request.getParameter("name1").length() != 0) {
			String category_name1 = request.getParameter("name1");
			CategoryBean categoryBean1 = new CategoryBean();
			categoryBean1.setCompany_id(company_id);
			categoryBean1.setCategory_name(category_name1);
			categoryBean1.setCompanyBean(companyBean);
			categoryService.save(categoryBean1);
			session.setAttribute("category_name1", categoryBean1);
		}
		
		if (request.getParameter("name2").length() != 0) {
			String category_name2 = request.getParameter("name2");
			CategoryBean categoryBean2 = new CategoryBean();
			categoryBean2.setCompany_id(company_id);
			categoryBean2.setCategory_name(category_name2);
			categoryBean2.setCompanyBean(companyBean);
			categoryService.save(categoryBean2);
		}
		
		if (request.getParameter("name3").length() != 0) {
			String category_name3 = request.getParameter("name3");
			CategoryBean categoryBean3 = new CategoryBean();
			categoryBean3.setCompany_id(company_id);
			categoryBean3.setCategory_name(category_name3);
			categoryBean3.setCompanyBean(companyBean);
			categoryService.save(categoryBean3);
		}
		
		if (request.getParameter("name4").length() != 0) {
			String category_name4 = request.getParameter("name4");
			CategoryBean categoryBean4 = new CategoryBean();
			categoryBean4.setCompany_id(company_id);
			categoryBean4.setCategory_name(category_name4);
			categoryBean4.setCompanyBean(companyBean);
			categoryService.save(categoryBean4);
		}
		
		if (request.getParameter("name5").length() != 0) {
			String category_name5 = request.getParameter("name5");
			CategoryBean categoryBean5 = new CategoryBean();
			categoryBean5.setCompany_id(company_id);
			categoryBean5.setCategory_name(category_name5);
			categoryBean5.setCompanyBean(companyBean);
			categoryService.save(categoryBean5);
		}
		
		

	}

}
