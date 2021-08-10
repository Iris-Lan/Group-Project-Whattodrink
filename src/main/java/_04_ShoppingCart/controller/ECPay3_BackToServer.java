package _04_ShoppingCart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.ecpayOperator.EcpayFunction;
import example.ExampleAllInOne;


@WebServlet("/_04_ShoppingCart/ECPay3_BackToServer")
public class ECPay3_BackToServer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		AllInOne all = new AllInOne();
		ExampleAllInOne.cmprChkMacValue();
		out.println("<html><head><title>Welcom</title></head><body>");
		out.println("HI");
		out.println(request.getAttribute("CheckMacValue")); 
		out.println("</body></html>");
		request.getAttribute("MerchantID");
		request.getAttribute("MerchantTradeNo");
		request.getAttribute("PaymentDate");
		request.getAttribute("PaymentType");
		request.getAttribute("PaymentTypeChargeFee");
		request.getAttribute("RtnCode");
		request.getAttribute("RtnMsg");
		request.getAttribute("SimulatePaid");
		request.getAttribute("StoreID");
		request.getAttribute("TradeAmt");
		request.getAttribute("TradeDate");
		request.getAttribute("TradeNo");
		request.getAttribute("RtnCode");
		request.getAttribute("RtnCode");



//        out.println(genAioCheckOutALL());
	}

}
