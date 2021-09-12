package _06_Maintain.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import _01_Register.b_01_register.model.CompanyBean;
import _03_ListDrinks.model.DrinkBean;
import _03_ListDrinks.service.DrinkService;
import _03_ListDrinks.service.serviceImpl.DrinkServiceImpl;

@MultipartConfig
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UpdateProductServlet.class);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("企業用戶顯示飲品列表之Controller-GET方法開始");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession(false);
		CompanyBean companyBean = (CompanyBean) session.getAttribute("BLoginOK");
		String company_id = companyBean.getCompany_id();
		System.out.println("1. ===========================");
		log.info("company_id: " + company_id);
		System.out.println("2. ===========================");
		
		DrinkService drinkService = new DrinkServiceImpl();
		List<DrinkBean> drinkBeanList = drinkService.findByCompanyId(company_id);

		System.out.println("3. ===========================");
		log.info("drinkBeanList: " + drinkBeanList);
		System.out.println("4. ===========================");		
		
		List<Map<String, Object>> list = new LinkedList<>();
		for (int i = 0; i < drinkBeanList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("proId", drinkBeanList.get(i).getProduct_id());
			map.put("proName", drinkBeanList.get(i).getProduct_name());
			map.put("proCap", drinkBeanList.get(i).getCapacity());
			map.put("picPath", drinkBeanList.get(i).getProduct_picpath());
			list.add(map);
		}
		response.getWriter().print(JSON.toJSONString(list));
		System.out.println("5. ===========================");
		System.out.println(JSON.toJSONString(list));
		System.out.println("6. ===========================");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
