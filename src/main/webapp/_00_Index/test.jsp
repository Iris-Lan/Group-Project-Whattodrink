<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form-1" method="post" action="<c:url value="/ee"/>">
	
	<label for="input-1">Input:</label>
	<input id="input-1" placeholder="Text" type="text" name="123"/>
	
	</form>
	
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>