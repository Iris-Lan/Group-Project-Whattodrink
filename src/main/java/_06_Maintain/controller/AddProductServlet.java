package _06_Maintain.controller;

import java.io.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
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
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import _01_Register.b_01_register.model.CompanyBean;
import _03_ListDrinks.model.CategoryBean;
import _03_ListDrinks.model.DrinkBean;
import _03_ListDrinks.model.TagBean;
import _03_ListDrinks.service.CategoryService;
import _03_ListDrinks.service.DrinkService;
import _03_ListDrinks.service.serviceImpl.CategoryServiceImpl;
import _03_ListDrinks.service.serviceImpl.DrinkServiceImpl;
import _07_Others.model.SugarLevelBean;
import _07_Others.model.SugarLimitBean;
import _07_Others.model.TempLevelBean;
import _07_Others.model.TempLimitBean;

@MultipartConfig
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(AddProductServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("企業用戶新增飲品之Controller-GET方法開始");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession(false);
		CompanyBean companyBean = (CompanyBean) session.getAttribute("BLoginOK");
		String company_id = companyBean.getCompany_id();
		System.out.println("1. ===========================");
		System.out.println(company_id);
		System.out.println("2. ===========================");

		CategoryService categoryService = new CategoryServiceImpl();
		List<CategoryBean> categoryBeanList = categoryService.findByCompanyId(company_id);
		System.out.println("3. ===========================");
		System.out.println(categoryBeanList);
		System.out.println("4. ===========================");

		List<Map<String, Object>> list = new LinkedList<>();
		Map<String, Object> qua = new HashMap<String, Object>();
		qua.put("qua", categoryBeanList.size());
		list.add(qua);
		for (int i = 0; i < categoryBeanList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", categoryBeanList.get(i).getCategory_name());
			list.add(map);
//			String tttt = [{"qua":8},{"name": "123"},{"name": "456"}];
		}
		response.getWriter().print(JSON.toJSONString(list));
		System.out.println("5. ===========================");
		System.out.println(JSON.toJSONString(list));
		System.out.println("6. ===========================");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("企業用戶新增飲品之Controller-POST方法開始");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		

		// 登入後取得該companyBean
		HttpSession session = request.getSession(false);
		CompanyBean companyBean = (CompanyBean) session.getAttribute("BLoginOK");
		String company_id = companyBean.getCompany_id();
		System.out.println("7. ===========================");
		log.info("company_id: " + company_id);

		DrinkService drinkService = new DrinkServiceImpl();
		
		// 準備產生兩筆同品名紀錄(L、M)
		DrinkBean drinkBeanL = new DrinkBean();
		DrinkBean drinkBeanM = new DrinkBean();

		// date
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		log.info("Timestamp: " + ts);
		drinkBeanL.setAdd_date(ts);
		drinkBeanL.setAlter_date(ts);
		drinkBeanM.setAdd_date(ts);
		drinkBeanM.setAlter_date(ts);

		// capacity
		drinkBeanL.setCapacity("L");
		drinkBeanM.setCapacity("M");

		// company, companyBean
		drinkBeanL.setCompany_id(company_id);
		drinkBeanL.setCompanyBean(companyBean);
		drinkBeanM.setCompany_id(company_id);
		drinkBeanM.setCompanyBean(companyBean);

		// name
		String pro_name = request.getParameter("pro_name");
		log.info("pro_name: " + pro_name);
		drinkBeanL.setProduct_name(pro_name);
		drinkBeanM.setProduct_name(pro_name);

		// price
		Integer price_L = Integer.parseInt(request.getParameter("price_L"));
		log.info("price_L: " + price_L);
		drinkBeanL.setProduct_price(price_L);
		Integer price_M = Integer.parseInt(request.getParameter("price_M"));
		log.info("price_L: " + price_M);
		drinkBeanM.setProduct_price(price_M);

		// cal
		Integer cal_L = Integer.parseInt(request.getParameter("cal_L"));
		log.info("cal_L: " + cal_L);
		drinkBeanL.setProduct_cal(cal_L);
		Integer cal_M = Integer.parseInt(request.getParameter("cal_M"));
		log.info("cal_M: " + cal_M);
		drinkBeanM.setProduct_cal(cal_M);
		
		// categories
		Integer catagory_id = Integer.parseInt(request.getParameter("catagories"));
		drinkBeanL.setCategory_id(catagory_id);
		drinkBeanM.setCategory_id(catagory_id);
		log.info("catagory_id: " + catagory_id);
		
		// CategoryBean
		CategoryBean categoryBean = drinkService.findByCategory_id(catagory_id);
		drinkBeanL.setCategory(categoryBean);
		drinkBeanM.setCategory(categoryBean);

		// picture
		String dirPath = "C:/_JSP/workspace" + getServletContext().getContextPath() + "/images/"
				+ companyBean.getCompany_id();
		log.info("dirPath: " + dirPath);

		String picName = dirPath + "/" + pro_name + ".jpg";
		log.info("picName: " + picName);

		Part part = request.getPart("pro_pic");
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		part.write(picName);

		drinkBeanL.setProduct_picname(picName.substring(picName.lastIndexOf("/") + 1));
		drinkBeanL.setProduct_picpath(picName.substring(picName.indexOf("images")));
		drinkBeanM.setProduct_picname(picName.substring(picName.lastIndexOf("/") + 1));
		drinkBeanM.setProduct_picpath(picName.substring(picName.indexOf("images")));

		System.out.println("===============================");
		drinkService.save(drinkBeanL);
		log.info("已寫入資料庫： " + drinkBeanL);
		drinkService.save(drinkBeanM);
		log.info("已寫入資料庫： " + drinkBeanM);
		System.out.println("===============================");

		request.setAttribute("newDrinkBeanL", drinkBeanL);
		request.setAttribute("newDrinkBeanM", drinkBeanM);

		DrinkBean newDrinkBeanL = (DrinkBean) request.getAttribute("newDrinkBeanL");
		Integer product_id_L = newDrinkBeanL.getProduct_id();
		log.info("product_id_L: " + product_id_L);

		DrinkBean newDrinkBeanM = (DrinkBean) request.getAttribute("newDrinkBeanM");
		Integer product_id_M = newDrinkBeanM.getProduct_id();
		log.info("product_id_M: " + product_id_M);

		// tag (checkbox: 前端已規定最多兩個標籤)
		TagBean tagBeanL1 = new TagBean();
		TagBean tagBeanL2 = new TagBean();
		TagBean tagBeanM1 = new TagBean();
		TagBean tagBeanM2 = new TagBean();

		String[] hashtagArray = request.getParameterValues("hashtag");;
		System.out.println("hashtagArray" + hashtagArray + "hashtagArray.length" + hashtagArray.length);
		System.out.println("===============================");
		String customized_tag = request.getParameter("customized");
//		System.out.println("customized_tag: " + customized_tag + customized_tag.length());
//		System.out.println("===============================");
//		try {
//			hashtagArray = request.getParameterValues("hashtag");
//		} catch (Exception e) {
//			System.out.println("丟出例外");
//		}
		try {
			List<String> hashtagList = Arrays.asList(hashtagArray);
			System.out.println("hashtagList: " + hashtagList + " hashtagList.size()" + hashtagList.size());			
		} catch (Exception e) {
			System.out.println("丟出例外");
		}

		if (hashtagArray.length == 1) {
			if (customized_tag.length() != 0) {
				// 僅有一個自訂標籤
				tagBeanL1.setProduct_id(product_id_L);
				tagBeanL1.setTag_name(customized_tag);
				tagBeanL1.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL1);
				tagBeanM1.setProduct_id(product_id_M);
				tagBeanM1.setTag_name(customized_tag);
				tagBeanM1.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM1);
//				log.info("customized_tag: " + customized_tag);				
			} else {
				// 僅有一個現成標籤
				String formatTag1 = hashtagArray[0];
				tagBeanL1.setProduct_id(product_id_L);
				tagBeanL1.setTag_name(formatTag1);
				tagBeanL1.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL1);

				tagBeanM1.setProduct_id(product_id_M);
				tagBeanM1.setTag_name(formatTag1);
				tagBeanM1.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM1);
//				log.info("formatTag: " + formatTag1);
			}

		} else if (hashtagArray.length == 2) {
			if (customized_tag.length() != 0) {
				// 一個現成標籤+一個自訂標籤
				String formatTag1 = hashtagArray[0];
				tagBeanL1.setProduct_id(product_id_L);
				tagBeanL1.setTag_name(formatTag1);
				tagBeanL1.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL1);

				tagBeanL2.setProduct_id(product_id_L);
				tagBeanL2.setTag_name(customized_tag);
				tagBeanL2.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL2);

				tagBeanM1.setProduct_id(product_id_M);
				tagBeanM1.setTag_name(formatTag1);
				tagBeanM1.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM1);

				tagBeanM2.setProduct_id(product_id_M);
				tagBeanM2.setTag_name(customized_tag);
				tagBeanM2.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM2);
//				log.info("formatTag: " + formatTag1);
//				log.info("customized_tag: " + customized_tag);
			} else {
				// 兩個皆為現成標籤
				String formatTag1 = hashtagArray[0];
				String formatTag2 = hashtagArray[1];
				tagBeanL1.setProduct_id(product_id_L);
				tagBeanL1.setTag_name(formatTag1);
				tagBeanL1.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL1);

				tagBeanM1.setProduct_id(product_id_M);
				tagBeanM1.setTag_name(formatTag1);
				tagBeanM1.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM1);

				tagBeanL2.setProduct_id(product_id_L);
				tagBeanL2.setTag_name(formatTag2);
				tagBeanL2.setDrinkBean(newDrinkBeanL);
				drinkService.save(tagBeanL2);

				tagBeanM2.setProduct_id(product_id_M);
				tagBeanM2.setTag_name(formatTag2);
				tagBeanM2.setDrinkBean(newDrinkBeanM);
				drinkService.save(tagBeanM2);
//					log.info("formatTag1: " + formatTag1 + " formatTag2: " + formatTag2);

			}
		}

		// sugar checkbox
		String[] sugarArray = request.getParameterValues("suger");
		List<String> sugarList = Arrays.asList(sugarArray);
		System.out.println("sugarArray.length: " + sugarArray.length);
//		log.info("sugar: " + sugarList);
		
		for (int i = 0; i < sugarArray.length; i++) {
			Integer sugar_id = Integer.parseInt(sugarArray[i]);
			SugarLimitBean sugarLimitBeanL = new SugarLimitBean();
			SugarLimitBean sugarLimitBeanM = new SugarLimitBean();
			SugarLevelBean sugarLevelBean = drinkService.findSugarLevelBeanBySugarId(sugar_id);
			
			sugarLimitBeanL.setProduct_id(product_id_L);
			sugarLimitBeanM.setProduct_id(product_id_M);
			
			sugarLimitBeanL.setSugar_id(sugar_id);
			sugarLimitBeanM.setSugar_id(sugar_id);
			
			sugarLimitBeanL.setDrinkBean(newDrinkBeanL);
			sugarLimitBeanM.setDrinkBean(newDrinkBeanM);
			
			sugarLimitBeanL.setSugarLevelBean(sugarLevelBean);
			sugarLimitBeanM.setSugarLevelBean(sugarLevelBean);
			
			drinkService.saveSugarLimitBean(sugarLimitBeanM);
			drinkService.saveSugarLimitBean(sugarLimitBeanL);

		}

		// temperature select
		String temp = request.getParameter("temp");
		System.out.println("////////////////");
		System.out.println(temp);
		System.out.println("////////////////");

//		log.info("temp: " + temp);
		if (temp.compareTo("hot") == 0) {
			for (int i = 5; i <= 6; i++) {

				TempLimitBean tempLimitBeanL = new TempLimitBean();
				TempLimitBean tempLimitBeanM = new TempLimitBean();
				TempLevelBean  tempLevelBean = drinkService.findTempLevelBeanByTempId(i);

				tempLimitBeanL.setProduct_id(product_id_L);
				tempLimitBeanM.setProduct_id(product_id_M);
				
				tempLimitBeanL.setTemp_id(i);
				tempLimitBeanM.setTemp_id(i);
				
				tempLimitBeanL.setTempLevelBean(tempLevelBean);
				tempLimitBeanM.setTempLevelBean(tempLevelBean);
				
				tempLimitBeanL.setDrinkBean(newDrinkBeanL);
				tempLimitBeanM.setDrinkBean(newDrinkBeanM);
				
				drinkService.saveTempLimitBean(tempLimitBeanL);
				drinkService.saveTempLimitBean(tempLimitBeanM);

			}
		} else if(temp.compareTo("ice") == 0){
			for (int i = 1; i <= 4; i++) {

				TempLimitBean tempLimitBeanL = new TempLimitBean();
				TempLimitBean tempLimitBeanM = new TempLimitBean();
				TempLevelBean  tempLevelBean = drinkService.findTempLevelBeanByTempId(i);

				tempLimitBeanL.setProduct_id(product_id_L);
				tempLimitBeanM.setProduct_id(product_id_M);
				
				tempLimitBeanL.setTemp_id(i);
				tempLimitBeanM.setTemp_id(i);
				
				tempLimitBeanL.setTempLevelBean(tempLevelBean);
				tempLimitBeanM.setTempLevelBean(tempLevelBean);
				
				tempLimitBeanL.setDrinkBean(newDrinkBeanL);
				tempLimitBeanM.setDrinkBean(newDrinkBeanM);
				
				drinkService.saveTempLimitBean(tempLimitBeanL);
				drinkService.saveTempLimitBean(tempLimitBeanM);
			}
		} else if (temp.compareTo("both") == 0){
			for (int i = 1; i <= 6; i++) {

				TempLimitBean tempLimitBeanL = new TempLimitBean();
				TempLimitBean tempLimitBeanM = new TempLimitBean();
				TempLevelBean  tempLevelBean = drinkService.findTempLevelBeanByTempId(i);

				tempLimitBeanL.setProduct_id(product_id_L);
				tempLimitBeanM.setProduct_id(product_id_M);
				
				tempLimitBeanL.setTemp_id(i);
				tempLimitBeanM.setTemp_id(i);
				
				tempLimitBeanL.setTempLevelBean(tempLevelBean);
				tempLimitBeanM.setTempLevelBean(tempLevelBean);
				
				tempLimitBeanL.setDrinkBean(newDrinkBeanL);
				tempLimitBeanM.setDrinkBean(newDrinkBeanM);
				
				drinkService.saveTempLimitBean(tempLimitBeanL);
				drinkService.saveTempLimitBean(tempLimitBeanM);
			}
		}


	}

}
