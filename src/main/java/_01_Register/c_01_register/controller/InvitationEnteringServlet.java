package _01_Register.c_01_register.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_Register.c_01_register.model.CustomerBean;
import _01_Register.c_01_register.service.CustomerService;
import _01_Register.c_01_register.service.serviceImpl.CustomerServiceImpl;

@WebServlet("/InvitationEnteringServlet")
public class InvitationEnteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String invitationCode = request.getParameter("invitationCode");
		CustomerService customerService = new CustomerServiceImpl();
		String contextPath = request.getContextPath();
		// 使用逾時
		if (session == null) {      
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/_00_Index/index.jsp"));
			return;
		}
		
		if (customerService.existsByInvitation(invitationCode)) {
			
			CustomerBean customerBean = (CustomerBean) session.getAttribute("CLoginOK");
			customerBean.setInvited_by(invitationCode);
			customerBean.setInvitationCount(customerBean.getInvitationCount() + 1);
			customerBean.setAlter_date(new Timestamp(System.currentTimeMillis()));
			
			CustomerBean inviter = customerService.findByInvitation(invitationCode);
			inviter.setInvitationCount(inviter.getInvitationCount() + 1);
			inviter.setAlter_date(new Timestamp(System.currentTimeMillis()));
			
			customerService.updateCustomers(customerBean, inviter);
			
			session.setAttribute("CLoginOK", customerBean);
			
			session.setAttribute("invitationCode", "恭喜你獲得好友專屬50元優惠");
			response.sendRedirect(request.getContextPath() + "/_07_Others/c__07_others_acount/myAccountCoupon.jsp");
		} else {
			request.setAttribute("invitationCode", "邀請碼輸入錯誤");
			RequestDispatcher rd = request.getRequestDispatcher("/_07_Others/c__07_others_acount/myAccountCoupon.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
