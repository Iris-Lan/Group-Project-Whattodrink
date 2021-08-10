package _04_ShoppingCart.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.InvoiceObj;


@WebServlet("/_04_ShoppingCart/TestForECPay2")
public class TestForECPay2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String productName;	
	public static AllInOne all;

    public TestForECPay2() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initial();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		productName = "珍珠奶茶x1 70元#冬瓜茶x1 35元";		
        out.println(genAioCheckOutALL());
		
		
		
//        String result = genAioCheckOutALL();
//		request.setAttribute("result", result);
//		RequestDispatcher rd = request.getRequestDispatcher("/ECPayResult.jsp");
//		rd.forward(request, response);
//		return;
        
	}
	
	private static void initial(){
		all = new AllInOne();
	}
	
	
	
	//ALL
	public static String genAioCheckOutALL(){		
		AioCheckOutALL obj = new AioCheckOutALL();
		InvoiceObj invoice = new InvoiceObj();
//		obj.setMerchantTradeNo("mknjbh");
		obj.setMerchantTradeNo(String.valueOf(System.currentTimeMillis()));
		obj.setMerchantTradeDate("2021/08/10 19:32:00");
		obj.setTotalAmount("105");
		obj.setTradeDesc("aaaxxx");
		obj.setItemName(productName);
//		EcpayFunction.genCheckMacValue(key, iv, obj);
		//必填，僅停留付款成功頁面，此處須設計頁面接收綠界交易結果並回傳參數
//		obj.setReturnURL("https://whattodrink.herokuapp.com/");
		obj.setReturnURL("https://payment.ecpay.com.tw/Cashier/AioCheckOut/V5");
//		obj.setReturnURL("https://whattodrink.000webhostapp.com/");
		
		//付款成功後按返回按鈕
//		obj.setClientBackURL("https://whattodrink.herokuapp.com/");
		
		
		//付款成功後返回client端網址  
		obj.setOrderResultURL("https://whattodrink.herokuapp.com/");
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
		invoice.setInvoiceItemWord("杯");
		invoice.setInvoiceItemPrice("70");
		invoice.setInvoiceItemTaxType("1");
		
		String form = all.aioCheckOut(obj, null);
		return form;
	}
	
	
	
	
}
