<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/_00_Index/slick/slick11.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/_00_Index/slick/slick-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/_00_Index/index2.css"/>">
<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="<c:url value="/_00_Index/slick/slick.js"/>"
		type="text/javascript" charset="utf-8"></script>
</head>

<body>

	<jsp:include page="/_08_Fragment/top.jsp" />

	<!-- category Start -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="category regular2">
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=紅茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/紅茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">紅茶</p> </a>
					</div>
					<div>


						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=綠茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/綠茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">綠茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=奶茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/鮮奶茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">奶茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=青茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/青茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">青茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=烏龍茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/烏龍茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">烏龍茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=鮮奶茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/奶茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">鮮奶茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=水果茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/水果茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">水果茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=抹茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/抹茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">抹茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=冬瓜茶"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/冬瓜茶_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">冬瓜茶</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=可可"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/可可_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">可可</p> </a>
					</div>
					<div>
						<a
							href="<c:url value="/_03_listDrinks/RetrieveDrinksByTag?tagName=冰沙"/>"
							style="text-decoration: none; color: #000"><img
							src="<c:url value="/images/冰沙_工作區域 1.png"/>" alt=""
							class="category-img" />
							<p class="category-text">冰沙</p> </a>
					</div>
				</div>


			</div>
			<div class="col-sm-1"></div>
		</div>

	</div>

	<!-- category End -->

	<!-- 即時飲品評價開始 -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<p style="font-size: 28px;">即時飲品評價</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">

				<div class="regular instance">

					<c:forEach varStatus="stVar" begin="0" end="4">
						<c:set value="${stVar.count}" var="indextest" />
						<div class="d-flex flex-row">
							<img
								src="<c:url value="/${commentArray[indextest-1].comment_picpath}"/>"
								style="width: 130px;">
							<h5>
								<a style="color: black"
									href="<c:url value="/_03_ListDrinks/StorePage?companyId=${drinkArray[indextest-1].companyBean.company_id}"/>"><b>${drinkArray[indextest-1].companyBean.company_name}-${drinkArray[indextest-1].companyBean.trade_name}</b></a><br>${drinkArray[indextest-1].product_name}<br>

								<c:set value="${commentArray[indextest-1].star}" var="star" />

								<c:forEach begin="1" end="${star}">
									<i class="fas fa-star"></i>
								</c:forEach>

								<br> <span>${commentArray[indextest-1].feedback}</span>
							</h5>
						</div>
					</c:forEach>







				</div>

			</div>
			<div class="col-sm-1"></div>
		</div>

	</div>
	<!-- 即時飲品評價結束 -->
	<!-- 附近的熱門店家開始 -->
	<div class="container-fluid">
		<div class="row mt-4">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<p style="font-size: 28px;">最新合作店家</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="regular1">

					<c:forEach varStatus="stVar" var="bb" items="${companyList}">
						<div class="hot">

<%-- 							<c:if test="${CLoginOK!=null}"> --%>
<%-- 								<c:forEach varStatus="stVar" var="ff" items="${favoriteBeans}"> --%>
<%-- 									<c:if test="${bb.company_id==ff.company_id}"> --%>
<!-- 										<i onclick="change1(this)" class="fas fa-heart fa-lg heart"></i> -->
<%-- 									</c:if> --%>
<%-- 									<c:if test="${bb.company_id!=ff.company_id}"> --%>
<!-- 										<i onclick="change1(this)" class="far fa-heart fa-lg heart"></i> -->
<%-- 									</c:if> --%>
<%-- 								</c:forEach> --%>
<%-- 							</c:if> --%>



							<a style="color: black"
								href="<c:url value="/_03_ListDrinks/StorePage?companyId=${bb.company_id}"/>"><img
								src="<c:url value="/${bb.company_iconpath}"/>" alt=""></a>
							<h5 style="margin: 5px 0px 0px 0px;">${bb.company_name}<i
									class="fas fa-star fa-lg"
									style="position: absolute; left: 10px; top: 14px; color: #F5C6AA;"></i>
							</h5>
							<p class="point0">4.2</p>
							<Input type='hidden' name='company' value='${bb.company_address}'
								class='hotcompanyAddress' /> <Input type='hidden'
								name='companyid' value='${bb.company_id}' />
							<p style="margin: 0px;">
								<i class="fas fa-street-view"></i>公尺
								${bb.trade_name}
							</p>
						</div>
					</c:forEach>

				</div>
				<div class="col-sm-1"></div>
			</div>




		</div>
	</div>

	<!-- 附近的熱門店家結束 -->

	<!-- 所有店家開始 -->


	<div class="container-fluid">
		<div class="row mt-4">
			<div class="col-sm-1"></div>
			<div class="col-sm-2 mx-auto">
				<div style="margin-bottom: 20px;">
					<p style="font-size: 28px;">所有店家</p>
					<p style="font-size: 22px;">分類</p>
					<form id="businessescategory">
						<input type="radio" name="category" value="Taipei" checked>專屬推薦<br>
						<input type="radio" name="category" value="Taoyuan">距離<br>
						<input type="radio" name="category" value="Taoyuan">評分<br>
					</form>

				</div>

			</div>

			<div
				class="col-sm-8 mx-auto d-flex flex-wrap justify-content-start lign-items-start">
				<c:forEach varStatus="stVar" var="aa" items="${companyList}">
					<div class="allshop">
						<div class="product-favorite">

							<c:if test="${CLoginOK!=null}">
								<i id="${aa.company_id}" onclick="change(this)" class="far fa-heart fa-lg heart"></i>
							</c:if>


						</div>
						<a style="color: black"
							href="<c:url value="/_03_ListDrinks/StorePage?companyId=${aa.company_id}"/>"><img
							src="<c:url value="/${aa.company_iconpath}"/>" alt=""></a>
						<h5>${aa.company_name}<i class="fas fa-star fa-lg"
								style="position: absolute; right: 8px; top: 169px; color: #F5C6AA;"></i>
						</h5>
						<p class="point">4.5</p>
						<Input type='hidden' name='companyAaddress'
							value='${aa.company_address}' class='companyAddress' /> <Input
							type='hidden' name='companyid' value='${aa.company_id}' />
						<p>

							<c:if test="${aa.company_id=='A01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${A01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='B01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${B01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='C01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${C01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='D01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${D01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='E01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${E01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='F01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${F01}公尺 ${aa.trade_name}
						</c:if>
							<c:if test="${aa.company_id=='G01'}">
								<i class="fas fa-street-view"></i>
								<span id="${stVar.count}"></span>${G01}公尺 ${aa.trade_name}
						</c:if>

						</p>
					</div>
				</c:forEach>
				<div class="col-sm-1"></div>
			</div>
			<div class="row">
				<div class="col-sm-10 mx-auto d-flex justify-content-center">
					<button type="button" class="btn btn-dark my-2" id="more">顯示更多</button>
				</div>
			</div>

		</div>
	</div>

	<!-- 所有店家結束 -->



	<!-- Modal(sharecode) start-->
	<div class="modal fade" id="sharecode" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">分享你的邀請碼給好友吧</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body d-flex justify-content-center"
					style="padding-top: 30px;">
					<i class="fas fa-gift fa-lg" id="Invitationcode">&nbsp;&nbsp;&nbsp;&nbsp;${CLoginOK.invitation}&nbsp;</i>
					<button type="button" class="btn"
						style="position: relative; bottom: 9px;" data-bs-container="body"
						data-bs-toggle="popover" data-bs-placement="right"
						data-bs-content="已複製">
						<i class="far fa-copy fa-lg" onclick="copy()"></i>
					</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-bs-dismiss="modal"
						aria-label="Close">完成</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal(sharecode) end-->

	<!-- footer end -->
	<footer id="footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="footer-content logo col-sm-5 m-0">
					<a href=""><img src="<c:url value="/images/logo.png"/>"
						alt="logo" class="small-logo" /></a>
					<div class="app_download">
						<a href="" class="text-dark text-decoration-none"><span
							class="border border-1 rounded-1 p-1 border-dark"><i
								class="fab fa-google-play me-1"></i>應用程式</span></a>
					</div>
				</div>
				<div class="col-sm-1"></div>
				<div class="footer-content col-sm-2">
					<a href="" class="link-dark text-decoration-none">關於我們</a> <a
						href="<c:url value="/_01_Register/b_01_register/1_business_register_1.jsp"/>"
						class="link-dark text-decoration-none">建立企業帳戶</a> <a
						href="<c:url value="/_02_Login/b_02_login/1_business_login.jsp"/>"
						class="link-dark text-decoration-none">登入您的商店</a>
				</div>
				<div class="footer-content col-sm-2">
					<a href="mailto:whattodrink2021@whattodrink.com"
						class="link-dark text-decoration-none">取得協助</a> <a href=""
						class="link-dark text-decoration-none">附近的商家</a> <a href=""
						class="link-dark text-decoration-none">切換語言</a>
				</div>
				<div class="col-sm-1"></div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="footer-content col-sm-10">
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="footer-content icons col-sm-5">
					<i class="fab fa-facebook"></i> <i class="fab fa-instagram"></i> <i
						class="fab fa-twitter"></i>
				</div>
				<div
					class="
              footer-content
              col-sm-5
              d-flex
              flex-direction-row
              align-items-end
            ">
					<span>&copy;2021 今天喝什麼 Inc.</span>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
	</footer>
	<!-- footer end -->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


	<script src="<c:url value="/_00_Index/index11.js"/>"></script>
	<!--   <script -->
	<!--       src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDx1N-wHeMdqX-ZieKXx2BeYnLz1drNa6U&callback=initMap&libraries=&v=weekly" -->
	<!--       async -->
	<!--     ></script> -->
	<!-- 	<script src="map.js"></script> -->

<script type="text/javascript">
let ee="${favoritecompany}";
let ee1 = ee.split(',');

for(i=0;i<ee1.length;i++){
	console.log(ee1[i]);
$(`#\${ee1[i]}`).attr("class","fas fa-heart fa-lg heart");
}
</script>

</body>

</html>