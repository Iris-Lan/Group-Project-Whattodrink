<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>忘記密碼</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="register_and_login.css" />
  </head>
  <body>
    <!-- header start-->
    <nav
      class="
        navbar
        container-fluid
        d-flex
        justify-content-center
        align-items-center
      "
    >
      <a class="navbar-brand d-flex" href="#">
         <img src="<c:url value="/images/logo.png"/>" alt="logo" />
      </a>
    </nav>
    <!-- header end-->

    <!-- content start-->
    <div class="main d-flex justify-content-center align-items-center">
      <div class="focus container">
        <div class="text-center mb-5">
          <h3>忘記密碼</h3>
        </div>
        <!-- 輸入信箱 -->
        <form class="row" id="input_email">
          <div class="col-10 mx-auto">
            <h4 class="mb-4">請輸入信箱</h4>
            <div style="height: 18.5vh">
              <input
                class="form-control form-control-lg"
                type="email"
                name="email"
                placeholder="信箱"
              />
            </div>
            <div>
              <button id="next" type="submit" class="btn btn-dark w-100 fs-5">
                下一步
              </button>
            </div>
          </div>
        </form>
        <!-- 輸入驗證碼 -->
        <form id="variviedCode" class="row d-none">
          <div class="col-10 mx-auto">
            <h4 class="mb-4">請輸入驗證碼</h4>
            <div style="height: 18.5vh">
              <input
                type="text"
                class="form-control form-control-lg"
                name="variviedCode"
                placeholder="驗證碼"
              />
              <span class="text-secondary">
                未收到驗證碼<a class="text-primary mx-1" id="resend"
                  >重新發送</a
                >
              </span>
            </div>
            <div>
              <button type="submit" class="btn btn-dark w-100 fs-5" id="next2">
                下一步
              </button>
            </div>
          </div>
        </form>
        <!-- 輸入密碼 -->
        <form
          id="resetPassword"
          class="row d-none"
          action="./1_business_login.html"
        >
          <div class="col-10 mx-auto">
            <h4 class="mb-4">請輸入新密碼</h4>
            <div style="height: 60%">
              <input
                type="password"
                name="password"
                id="password"
                class="form-control form-control-lg"
                placeholder="密碼"
              />
              <input
                type="password"
                name="password2"
                class="form-control form-control-lg mt-3"
                placeholder="再次輸入密碼"
              />
            </div>
            <div class="mt-3">
              <button
                type="submit"
                class="btn btn-dark w-100 fs-5"
                id="send_password"
              >
                完成
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <!-- content end-->

     <!-- footer start -->
    <footer id="footer">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-1"></div>
          <div class="footer-content logo col-sm-5 m-0">
            <a href=""><img src="<c:url value="/images/logo.png"/>" alt="logo" /></a>
            <div class="app_download">
              <a href="" class="text-dark text-decoration-none"
                ><span class="border border-1 rounded-1 p-1 border-dark"
                  ><i class="fab fa-google-play me-1"></i>應用程式</span
                ></a
              >
            </div>
          </div>
          <div class="col-sm-1"></div>
          <div class="footer-content col-sm-2">
            <a href="" class="link-dark text-decoration-none">關於我們</a>
            <a
              href="<c:url value="/_01_Register/b_01_register/1_business_register_1.jsp"/>"
              class="link-dark text-decoration-none"
              >建立企業帳戶</a
            >
            <a
              href="<c:url value="/_02_Login/b_02_login/1_business_login.jsp"/>"
              class="link-dark text-decoration-none"
              >登入您的商店</a
            >
          </div>
          <div class="footer-content col-sm-2">
            <a href="mailto:whattodrink2021@whattodrink.com" class="link-dark text-decoration-none">取得協助</a>
            <a href="" class="link-dark text-decoration-none">附近的商家</a>
            <a href="" class="link-dark text-decoration-none">切換語言</a>
          </div>
          <div class="col-sm-1"></div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="footer-content col-sm-10"><hr /></div>
        </div>
        <div class="row">
          <div class="col-sm-1"></div>
          <div class="footer-content icons col-sm-5">
            <i class="fab fa-facebook"></i>
            <i class="fab fa-instagram"></i>
            <i class="fab fa-twitter"></i>
          </div>
          <div
            class="
              footer-content
              col-sm-5
              d-flex
              flex-direction-row
              align-items-end
            "
          >
            <span>&copy;2021 今天喝什麼 Inc.</span>
          </div>
          <div class="col-sm-1"></div>
        </div>
      </div>
    </footer>
    <!-- footer end -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/additional-methods.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    <script src="<c:url value="/_02_Login/b_02_login/1_business_forgot_password.js"/>"></script>
  </body>
</html>
