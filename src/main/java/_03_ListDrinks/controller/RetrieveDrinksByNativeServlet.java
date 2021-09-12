package _03_ListDrinks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _03_ListDrinks.model.DrinkBean;
import _03_ListDrinks.service.DrinkService;
import _03_ListDrinks.service.serviceImpl.DrinkServiceImpl;

@WebServlet("/_03_listDrinks/RetrieveDrinksByNative")
public class RetrieveDrinksByNativeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		String searchString = (String) request.getParameter("keyword");
		DrinkService drinkService = new DrinkServiceImpl();
		List<DrinkBean> searchResultBeans = drinkService.findByProductName(searchString);
	
		session.setAttribute("searchResult", searchResultBeans);
		session.setAttribute("tagNameOrKeyword", searchString);
		
		RequestDispatcher rd = request.getRequestDispatcher("/_03_ListDrinks/c_03_searchResult/search.jsp");
		rd.forward(request, response);
		return;
	}
}