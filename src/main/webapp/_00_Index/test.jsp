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
	
	<a href="<c:url value="/RetrieveDrinksByPriceServlet?searchMethod=tagSearch&tagNameOrKeyword=鮮奶茶"/>">tagSearch p</a>
	<a href="<c:url value="/RetrieveDrinksByPriceServlet?searchMethod=nativeSearch&tagNameOrKeyword=熟成"/>">nativeSearch p</a>
	<a href="<c:url value="/RetrieveDrinksByCalServlet?searchMethod=nativeSearch&tagNameOrKeyword=熟成"/>">nativeSearch c</a>
	<a href="<c:url value="/RetrieveDrinksByCalServlet?searchMethod=tagSearch&tagNameOrKeyword=鮮奶茶"/>">tagSearch c</a>
	<a href="<c:url value="/RetrieveDrinksByPriceServlet?order_id=11A1"/>">測試</a>
	<a href="<c:url value="/Orderbydistance"/>">測試11</a>
	
<input class="form-control" id="blockimg" type="file" >
<button id="upload">Upload</button>


 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script type="text/javascript">

//$.ajax

 $('#upload').on('click', function() {
    var file_data = $('#blockimg').prop('files')[0];   //取得上傳檔案屬性
    var form_data = new FormData();  //建構new FormData()
    form_data.append('file', file_data);  //吧物件加到file後面
                              
    $.ajax({
                url: 'upload.php',
                cache: false,
                contentType: false,
                processData: false,
                data: form_data,     //data只能指定單一物件                 
                type: 'post',
               success: function(data){
                    $('#ajsxboxdhow').html(data);
                }
     });
});
 </script>
</body>
</html>