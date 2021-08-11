<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	CheckMacValue: ${requestScope.CheckMacValue} 
	MerchantID: ${requestScope.MerchantID} 
	MerchantTradeNo: ${requestScope.MerchantTradeNo} 
	PaymentDate: ${requestScope.PaymentDate} 
	PaymentType: ${requestScope.PaymentType} 
	PaymentTypeChargeFee: ${requestScope.PaymentTypeChargeFee} 
	RtnCode: ${requestScope.RtnCode} 
	RtnMsg: ${requestScope.RtnMsg} 
	SimulatePaid: ${requestScope.SimulatePaid} 
	StoreID: ${requestScope.StoreID} 
	TradeAmt: ${requestScope.TradeAmt} 
	TradeDate: ${requestScope.TradeDate} 
	TradeNo: ${requestScope.TradeNo} 
	
	<a href="<c:url value='/index.jsp'/>">HOME</a>
	
</body>
</html>