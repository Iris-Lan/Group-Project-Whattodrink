package _04_ShoppingCart.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_04_ShoppingCart/CheckingMacValue")
public class CheckingMacValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String IP_ADDR = "localhost";
	public static final int PORT = 80;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("伺服器端啟動...");  
//		System.out.println("等待接收伺服器端回傳付款結果");
//      
//	  	try (
//				//建立ServerSocket連線埠號
//				ServerSocket serverSocket = new ServerSocket(PORT);
//	  			//已和遠方客戶端連線
//	  			Socket socket = serverSocket.accept();
//				//讀取客戶端資料
//				DataInputStream input = new DataInputStream(socket.getInputStream());
//				//向伺服器傳送資料
//				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//			){
//		  		while(input != null) {
//		  			String fromClient = input.readUTF();
//		  			System.out.println("客戶端傳來的結果: " + fromClient);
//	            }
//		  		
//		  		
////      		fromServer.split("&");
//  	
////      		&CustomField1=&CustomField2=&CustomField3=&CustomField4=&MerchantID=2000132
////				&MerchantTradeNo=Test1510056539&PaymentDate=2017/11/02 16:22:18
////				&PaymentType=Credit_CreditCard&PaymentTypeChargeFee=1&RtnCode=1&RtnMsg=交易成功
////				&SimulatePaid=0&StoreID=&TradeAmt=100&TradeDate=2017/11/07 20:08:59&TradeNo=17110720085960236789
////				&CheckMacValue= 9139AF2AC5D0F9EBC5F3CD44064F666AAA62F0B202B95B341CC25E080EA4FC6E
//		  		System.out.println("連線結束");
//	  	}catch(Exception e) {
//	  		System.out.println("伺服器端異常:" + e.getMessage());
//	  	}
		
		
		
		
		System.out.println("客戶端啟動...");  
        System.out.println("等待接收伺服器端回傳付款結果");

        
    	try (
			//建立socket連線至指定主機埠號
			Socket socket = new Socket(IP_ADDR, PORT);
			//讀取伺服器端資料
			DataInputStream input = new DataInputStream(socket.getInputStream());
			//向伺服器傳送資料
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		){
    		while(input != null) {
    			String fromServer = input.readUTF();
    			System.out.println("伺服器傳來的結果: " + fromServer);
            }
    		
    		
//        		fromServer.split("&");
    	
//        		&CustomField1=&CustomField2=&CustomField3=&CustomField4=&MerchantID=2000132
//				&MerchantTradeNo=Test1510056539&PaymentDate=2017/11/02 16:22:18
//				&PaymentType=Credit_CreditCard&PaymentTypeChargeFee=1&RtnCode=1&RtnMsg=交易成功
//				&SimulatePaid=0&StoreID=&TradeAmt=100&TradeDate=2017/11/07 20:08:59&TradeNo=17110720085960236789
//				&CheckMacValue= 9139AF2AC5D0F9EBC5F3CD44064F666AAA62F0B202B95B341CC25E080EA4FC6E
    		System.out.println("連線結束");
    	}catch(Exception e) {
    		System.out.println("客戶端異常:" + e.getMessage());
    	}
        	
        
        
        
		
		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		System.out.println("HI");
//		String key = request.getParameter("MerchantID");
//		System.out.println("after HI");
//		String iv = "50BE3989953C1734E32DD18EB23698241E035F9CBCAC74371CCCF09E0E15BD61";
//		String merchantTradeNo = request.getParameter("MerchantTradeNo");
//		String paymentDate = request.getParameter("PaymentDate");
//		String paymentType = request.getParameter("PaymentType");
//		String paymentTypeChargeFee = request.getParameter("PaymentTypeChargeFee");
//		String rtnCode = request.getParameter("RtnCode");
//		String rtnMsg = request.getParameter("RtnMsg");
//		String simulatePaid = request.getParameter("SimulatePaid");
//		String tradeAmt = request.getParameter("TradeAmt");
//		String tradeDate = request.getParameter("TradeDate");
//		String tradeNo = request.getParameter("TradeNo");
//		String checkMacValue = request.getParameter("CheckMacValue");
//		
//		
//		ATMRequestObj obj = new ATMRequestObj();
//		obj.setMerchantID(key);
//		obj.setMerchantTradeNo(merchantTradeNo);
//		obj.setPaymentDate(paymentDate);
//		obj.setPaymentType(paymentType);
//		obj.setPaymentTypeChargeFee(paymentTypeChargeFee);
//		obj.setRtnCode(rtnCode);
//		obj.setRtnMsg(rtnMsg);
//		obj.setSimulatePaid(simulatePaid);
//		obj.setTradeAmt(tradeAmt);
//		obj.setTradeDate(tradeDate);
//		obj.setTradeNo(tradeNo);
//		obj.setCheckMacValue(checkMacValue);
//		
//		
//		System.out.println("merchantTradeNo" + merchantTradeNo);
//		System.out.println("paymentDate" + paymentDate);
//		System.out.println("paymentType" + paymentType);
//		System.out.println("paymentTypeChargeFee" + paymentTypeChargeFee);
//		System.out.println("rtnCode" + rtnCode);
//		System.out.println("rtnMsg" + rtnMsg);
//		System.out.println("simulatePaid" + simulatePaid);
//		System.out.println("tradeAmt" + tradeAmt);
//		System.out.println("tradeDate" + tradeDate);
//		System.out.println("tradeNo" + tradeNo);
//		System.out.println("checkMacValue" + checkMacValue);
//		
//		System.out.println("------");
//		System.out.println(EcpayFunction.genCheckMacValue(key, iv, obj));
//		
//		if(rtnCode.equals("1")) {
//			System.out.println("1|OK");
//			response.getWriter().write("1|OK");
//			return;
//		}
//		System.out.println("Fail");
//		
		
		
		
	}

}
