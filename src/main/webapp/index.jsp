<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		function getOrdersByCompanyId() {	
			document.forms[0].action="<c:url value='/_04_ShoppingCart/showOrdersByCompanyId'/>" ;
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


	<!-- 	綠界測試 -->
	<form action="<c:url value='/_04_ShoppingCart/TestForECPay2'/>"
		method="POST">
		<input type="button" value="付款去~" onclick="reconfirmOrder()" />
	</form>

	<!-- 	indexFilter 提供前端熱門公司bean 評論bean 飲料bean所有data  -->
	<!-- 			CompanyService companyService = new CompanyServiceImpl(); -->
	<!-- 			List<CompanyBean> companyBeans = companyService.findAllByHitRank(); -->
	<!-- 			request.setAttribute("companyList", companyBeans);		 -->

	<!-- 		CommentService commentService = new CommentServiceImpl(); -->
	<!-- 		List<CommentBean> commentBeans = commentService.findAllCommentBeans(); -->
	<!-- 		LinkedList<DrinkBean> drinkList = new LinkedList<>(); -->
	<!-- 		request.setAttribute("commentListLength", commentBeans.size()); -->

	<!-- 		CommentBean[] commentArray = commentBeans.toArray(new CommentBean[commentBeans.size()]); -->
	<!-- 		request.setAttribute("commentArray", commentArray); -->

	<!-- 		DrinkService drinkService = new DrinkServiceImpl(); -->

	<!-- 		for(CommentBean bean : commentBeans) { -->
	<!-- 			drinkList.add(drinkService.findById(bean.getProduct_id())); -->
	<!-- 		} -->
	<!-- 		DrinkBean[] drinkArray = drinkList.toArray(new DrinkBean[drinkList.size()]); -->
	<!-- 		request.setAttribute("drinkArray", drinkArray); -->

	<!-- 		chain.doFilter(request, response); -->

	<!-- 	index 前端迴圈呈現  -->
	<c:forEach varStatus="stVar" begin="0" end="${commentListLength}">
		<c:set value="${stVar.count}" var="indextest" />
			${commentArray[indextest-1].feedback}
			${drinkArray[indextest-1].product_name}
			${drinkArray[indextest-1].companyBean.company_name}<br>
	</c:forEach>

	<c:forEach var="companyList" items="${companyList}">
		${companyList.company_id}
		${companyList.company_name}
	</c:forEach>


	<a href="<c:url value='/page1.jsp'/>">page1.jsp</a>
	<br>
	<!-- 	<a href="" id="drinkDetail">DrinkDetail</a><br> -->
	<h6 id="drinkDetail">DrinkDetail</h6>
	<br>


	<!--  前端提出請求 特定公司的所有orders  -->
	<form action="<c:url value='/_04_ShoppingCart/showOrdersByCompanyId'/>"
		method="POST">
		<input type="button" value="XXX公司的所有訂單"
			onclick="getOrdersByCompanyId()" />
	</form>
	<br>





	
	<button id="addInvitation">addInvitation</button>
	<button id="orders">orders</button>
	<button id="orderHistoryItemDetail">orderHistoryItemDetail</button>
	<button id="orderHistoryDelete">B_orderHistoryDelete</button>
	<button id="changeItemStatus">changeItemStatus</button>
	<button id="orderHistory">orderHistory</button>
	<button id="Bitems">未處理訂單的所有細項(待製作、製作中)</button>
	<input type="button" id='deleteCartOrderBean' value="清空cartOrderBean" />
	<input type="button" id='deleteCart' value="清空購物車" />
	<input type="button" id='deleteKey' value="刪除特定key的購物車列 測試key2" />
	<a href="http://localhost:8080/whattodrink/_00_Index/index.jsp">index</a>
	<a href="http://localhost:8080/whattodrink/_01_Register/c_01_register/LoginRegister.jsp">登入</a>
	<a href="http://localhost:8080/whattodrink/C_LogoutServlet">登出</a>
<!-- 	<input type="button" id='logout' value="登出" /> -->


	<c:choose>
		<c:when test="${CLoginOK != null}">
			${CLoginOK.invitationCount}
			
		</c:when>
		<c:otherwise>現在沒有CLoginOK</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${ShoppingCart != null}">
			${ShoppingCart.cartSum}
			<c:forEach var="cart" varStatus="stVar"  items="${ShoppingCart.shoppingCart}">
			<c:set value="${stVar.count}" var="index" />
			-------------------------------------------
				key: ${cart.key} 和 id: ${cart.value.product_id}<br>
				cart: ${cart.value}<br>
				topping: ${cart.value.itemToppings}<br>
			</c:forEach>
		</c:when>
		<c:otherwise>現在沒有購物車</c:otherwise>
	</c:choose>



	<!--  前端 呈現特定公司的所有orders  -->
	<c:forEach var="list" items="${getOrdersByCompanyIdTest}">
		${list}<br>
	</c:forEach>




	<!-- 	表單 後端複製圖到其他路徑或insert DB  -->
	<form action="<c:url value="/_03_ListDrinks/DrinkDetail"/>"
		method="post" enctype="multipart/form-data">
		<br> 上傳頭像: <input type="file" name="imageFile" /> <br> <br>
		<input type="submit" value="上傳">
	</form>


	<!-- 	ajax要求特定飲料的所有detail 包含公司 冰度 甜度 配料等其他beanList的data 
		後端提供Map格式的beanList Json  -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		$("#drinkDetail").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/_03_ListDrinks/DrinkDetail",
				type: "POST",
				data: {"productId" : "4"},
				dataType:"json",
				async: false,
				success(res){
					console.log(res);
// 					console.log(res.drinkNameAndCapacity);
// 					console.log(res.tempIdJson);
// 					console.log(res.tempNameJson);
// 					console.log(res.sugarIdJson);
// 					console.log(res.sugarNameJson);
// 					console.log(res.toppingNameJson);
// 					console.log(res.toppingIdJson);
					
// 					console.log(res.tempJson); 								      //tempStringArray
// 					console.log(res.sugarJson); 								  //tempStringArray
// 					console.log(res.drinkJson[0].category.companyBean.toppings);  //toppingsArray
// 					console.log(res.drinkJson[0].product_name);				      //drinkBeanAllData
				}
			})
		});
		

		
		$("#deleteCart").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/_04_ShoppingCart/deleteCartServlet",
				type: "POST",
				data: {"deleteCart" : "deleteCart"},
				dataType:"json",
				async: false,
				success(res){
					alert('刪除OK');
				}
			})
		});
		
		$("#deleteKey").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/_04_ShoppingCart/deleteCartServlet",
				type: "POST",
				data: {"deleteSingle" : "2"},
				dataType:"json",
				async: false,
				success(res){
					alert('刪除OK');
				}
			})
		});
		$("#orderHistory").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_orderHistory",
				type: "POST",
				dataType:"json",
				async: false,
				success(res){
					console.log(res);
					console.log(res[0].length);
					console.log(res[res.length -2].order_id);
				}
			})
		});
		$("#Bitems").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_item",
				type: "POST",
				dataType:"json",
				async: false,
				success(res){
					console.log(res);
					console.log(res.length);
					console.log(res[res.length -1].length);
					console.log(res[res.length -2].order_id);
					console.log(res[res.length -2].toppings.length);
					console.log(res[res.length -2].toppings[0]);
				}
			})
		});
		$("#orders").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_order",
				type: "POST",
				dataType:"json",
				async: false,
				success(res){
					console.log(res);
					
				}
			})
		});
		$("#changeItemStatus").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_itemStatusChange",
				type: "POST",
				dataType:"json",
				data: {"item_id": "120", "itemStatus":"已完成"},
				async: false,
				success(res){
					console.log(res);
				}
			})
		});
		$("#orderHistoryDelete").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_orderHistoryDelete",
				type: "POST",
				dataType:"json",
				data: {"order_id": "C0120210907001"},
				async: false,
				success(res){
					console.log(res);
				}
			})
		});
		$("#orderHistoryItemDetail").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/B_orderHistoryItemDetail",
				type: "POST",
				dataType:"json",
				data: {"order_id": "E0120210906003"},
				async: false,
				success(res){
					console.log(res);
					console.log(res.length);
					console.log(res[0].length);
					console.log(res[res.length -1].useDiscount);
					console.log(res[1].toppings[0]);
				}
			})
		});
		$("#addInvitation").click(function(){
			$.ajax({
				url: "http://localhost:8080/whattodrink/InvitationEnteringServlet",
				type: "POST",
				dataType:"json",
				data: {"invitationCode": "aJDxmai2"},
				async: false,
				success(res){
					
				}
			})
		});

	
	</script>

</body>
</html>
