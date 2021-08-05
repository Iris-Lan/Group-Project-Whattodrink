package _04_ShoppingCart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.InvoiceObj;


@WebServlet("/_04_ShoppingCart/TestForECPay")
public class TestForECPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String productName;	
	public static AllInOne all;

    public TestForECPay() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initial();
		response.setContentType("text/html;charset=UTF-8");
		productName = request.getParameter("productName");
        PrintWriter out = response.getWriter();
        out.println(genAioCheckOutALL());
        
	}
	
	private static void initial(){
		all = new AllInOne();
	}
	
	
	
	//ALL
	public static String genAioCheckOutALL(){		
		AioCheckOutALL obj = new AioCheckOutALL();
		InvoiceObj invoice = new InvoiceObj();		
		obj.setMerchantTradeNo("test990o0");
		obj.setMerchantTradeDate("2021/07/23 15:14:00");
		obj.setTotalAmount("100");
		obj.setTradeDesc("aaaa");
		obj.setItemName(productName);
//		EcpayFunction.genCheckMacValue(key, iv, obj);
		//必填，僅停留付款成功頁面，此處須設計頁面接收綠界交易結果並回傳參數
//		obj.setReturnURL("https://whattodrink.000webhostapp.com/");
		obj.setReturnURL("https://whattodrink.herokuapp.com/");
		
		//付款成功後按返回按鈕
		obj.setClientBackURL("https://whattodrink.herokuapp.com/");
		
		
		//付款成功後返回client端網址  
//		obj.setOrderResultURL("https://whattodrink.000webhostapp.com/");
		obj.setNeedExtraPaidInfo("N");
		
		obj.setInvoiceMark("Y");
		invoice.setRelateNumber("202107233");
		invoice.setCustomerID("123456");
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("0");
		invoice.setPrint("0");
		invoice.setCustomerName("Bellll");
		invoice.setCustomerAddr("台北市南港區三重路");
		invoice.setCustomerPhone("0911429215");
		invoice.setDelayDay("0");
		invoice.setInvType("07");
		invoice.setInvoiceItemName("測試");
		invoice.setInvoiceItemCount("1");
		invoice.setInvoiceItemWord("個");
		invoice.setInvoiceItemPrice("50");
		invoice.setInvoiceItemTaxType("1");
		
		String form = all.aioCheckOut(obj, null);
		return form;
	}
	
	
	
	
}
