<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	
	<script type="text/javascript">
		function reconfirmOrder() {	
			document.forms[0].action="<c:url value='/_04_ShoppingCart/TestForECPay2'/>" ;
			document.forms[0].method="POST";
			document.forms[0].submit();
		}
	</script>
	
</head>
<body>
	<h1>Hello World!</h1>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
	
	
	<form action="<c:url value='/_04_ShoppingCart/TestForECPay2'/>"  method="POST" >
		<input type="button" value="付款去~" onclick="reconfirmOrder()"/>
	</form>
	
	<a href="<c:url value='/page1.jsp'/>">HI</a>
</body>
</html>
