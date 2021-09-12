<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>我的訂單</title>
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

    <link rel="stylesheet" href="<c:url value="/_05_Order/c_05_order/myOrder.css" />" />
    
    <style>
      .text-secondary {
        margin: unset;
      }
      #no_margin {
        margin: unset;
      }
      h5 {
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
      }
    </style>
  </head>

  <body>
  
   <jsp:include page="/_08_Fragment/top.jsp" />
  
    <!-- content start -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-10 mx-auto">
          <!-- waiting order -->
          <h4 class="mb-4 mt-5">目前的訂單</h4>
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span
                ><span class="text-danger">&nbsp;待領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  class="me-2"
                  role="button"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
                <a
                  style="text-decoration: none"
                  class="me-2"
                  role="button"
                  data-bs-toggle="modal"
                  data-bs-target="#number"
                  >檢視號碼牌</a
                >
              </p>
            </div>
            <div class="col-sm-3 d-flex my-auto">
              <button
                type="submit"
                class="btn btn-dark"
                data-bs-toggle="modal"
                data-bs-target="#pick_up"
                style="width: 200px"
              >
                已領取
              </button>
            </div>
          </div>
          <hr class="my-4" style="background-color: black" />
          <!-- past order -->
          <h4 class="mb-4">過去的訂單</h4>
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span><span>&nbsp;已領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  role="button"
                  class="me-2"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
              </p>
            </div>
            <div class="col-sm-3 my-auto d-flex flex-column">
              <button
                type="submit"
                class="btn btn-dark mb-3"
                style="width: 200px"
              >
                重新訂購
              </button>
              <button type="submit" class="btn btn-dark" style="width: 200px">
                去評價
              </button>
            </div>
          </div>
          <hr class="my-4" style="background-color: black" />
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span><span>&nbsp;已領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  role="button"
                  class="me-2"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
              </p>
            </div>
            <div class="col-sm-3 my-auto d-flex flex-column">
              <button
                type="submit"
                class="btn btn-dark mb-3"
                style="width: 200px"
              >
                重新訂購
              </button>
              <button
                type="submit"
                class="btn btn-dark"
                style="width: 200px"
                data-bs-toggle="modal"
                data-bs-target="#review"
              >
                已評價
              </button>
            </div>
          </div>
          <hr class="my-4" style="background-color: black" />
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span><span>&nbsp;已領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  role="button"
                  class="me-2"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
              </p>
            </div>
            <div class="col-sm-3 d-flex my-auto flex-column">
              <button
                type="submit"
                class="btn btn-dark mb-3"
                style="width: 200px"
              >
                重新訂購
              </button>
              <button type="submit" class="btn btn-dark" style="width: 200px">
                去評價
              </button>
            </div>
          </div>
          <hr class="my-4" style="background-color: black" />
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span><span>&nbsp;已領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  role="button"
                  class="me-2"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
              </p>
            </div>
            <div class="col-sm-3 d-flex my-auto flex-column">
              <button
                type="submit"
                class="btn btn-dark mb-3"
                style="width: 200px"
              >
                重新訂購
              </button>
              <button type="submit" class="btn btn-dark" style="width: 200px">
                去評價
              </button>
            </div>
          </div>
          <hr class="my-4" style="background-color: black" />
          <div class="row">
            <div class="col-sm-2">
              <figure class="figure">
                <a href="">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                    alt="..."
                  />
                </a>
              </figure>
            </div>
            <div class="col-sm-4 mb-2">
              <h5>可不可熟成紅茶・板橋中山店</h5>
              <p class="text-secondary">YYYY-MM-DD&nbsp;HH:mm</p>
            </div>
            <div class="col-sm-3 mb-3">
              <p style="margin: 0px 0px 8px 0px">
                <span>訂單狀態</span><span>&nbsp;已領取</span>
              </p>
              <p id="no_margin">
                <a
                  style="text-decoration: none"
                  role="button"
                  class="me-2"
                  data-bs-toggle="modal"
                  data-bs-target="#details"
                  >檢視電子明細</a
                >
              </p>
            </div>
            <div class="col-sm-3 d-flex my-auto flex-column">
              <button
                type="submit"
                class="btn btn-dark mb-3"
                style="width: 200px"
              >
                重新訂購
              </button>
              <button type="submit" class="btn btn-dark" style="width: 200px">
                去評價
              </button>
            </div>
          </div>
          <!-- show more -->
          <div class="d-flex mt-5">
            <button
              type="submit"
              class="btn btn-dark mx-auto"
              style="width: 200px"
              id="more"
            >
              顯示更多
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- content end -->

  
    <!-- pick up Modal -->
    <div class="modal fade" id="pick_up" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title"></h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
            ></button>
          </div>
          <div class="modal-body">
            <span class="text-secondary" style="font-size: small"
              >YYYY-MM-DD&nbsp;HH:mm</span
            >
            <p class="fw-bold">感謝您的訂購</p>
            <p class="fs-5 fw-bold">
              此頁面表示：<br />飲品已經當面交付給您，<br />且數量與內容物皆正確。
            </p>
          </div>
          <div class="modal-footer justify-content-center">
            <button
              type="button"
              class="btn btn-dark"
              style="width: 200px"
              data-bs-dismiss="modal"
              id="check"
              name="time"
            >
              確認
            </button>
          </div>
        </div>
      </div>
    </div>

    <!-- details Modal -->
    <div class="modal fade" id="details" tabindex="-1">
      <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">訂單明細</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
            ></button>
          </div>
          <div class="modal-body px-4">
            <span class="text-secondary" style="font-size: small"
              >YYYY-MM-DD&nbsp;HH:mm</span
            >
            <p id="no_margin" class="fw-bold">感謝您的訂購</p>
            <table class="table">
              <thead style="font-weight: unset">
                <tr>
                  <th scope="col-sm-5">品項<br />名稱</th>
                  <th scope="col-sm-5">品項<br />細節</th>
                  <th scope="col-sm-1">品項<br />金額</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>黑糖珍珠好濃鮮奶</td>
                  <td>L&nbsp;甜度固定&nbsp;去冰&nbsp;小貼紙</td>
                  <td>&dollar;&nbsp;</td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td>&dollar;&nbsp;</td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td>&dollar;&nbsp;</td>
                </tr>
              </tbody>
            </table>
            <div
              class="fw-bold d-flex mb-2"
              style="justify-content: space-between"
            >
              <span>總計</span>
              <span>&dollar;</span>
            </div>
            <div
              class="fw-bold d-flex mb-2"
              style="justify-content: space-between"
            >
              <span>付款方式</span>
              <span>信用卡</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- number Modal -->
    <div class="modal fade" id="number" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">號碼牌</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <h4 class="d-flex justify-content-center">取餐時請出示號碼牌</h4>
            <div
              style="
                border-radius: 15px;
                border: black 2px solid;
                padding: 20px;
                margin: 20px;
              "
              id="textArea"
            >
              <div class="row mb-3">
                <div class="d-flex" style="justify-content: space-between">
                  <a
                    ><img src="<c:url value="/images/logo.png"/>" alt="logo" class="small-logo"
                  /></a>
                  <a
                    role="button"
                    class="fs-5 text-dark"
                    onclick="copyToClickBoard()"
                    ><i class="far fa-copy"></i
                  ></a>
                </div>
              </div>
              <div class="row">
                <div>
                  <p class="fw-bold">取餐時間</p>
                  <hr style="background-color: black" />
                  <p class="d-flex justify-content-center">yyyy-MM-dd HH:mm</p>
                </div>
              </div>
              <div class="row">
                <div>
                  <p class="fw-bold">取餐編號</p>
                  <hr style="background-color: black" />
                  <p
                    class="d-flex justify-content-center fs-1 fw-bold"
                    style="margin: 0px"
                  >
                    150
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- review Modal -->
    <div class="modal fade" id="review" tabindex="-1">
      <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">過去的評價</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-sm-10 mx-auto">
                <div class="row mb-3">
                  <div class="col-sm-6">
                    <img
                      class="ratio ratio-4x3"
                      src="https://picsum.photos/400/300/?blur=2"
                      style="max-width: fit-content"
                    />
                  </div>
                  <div class="col-sm-6">
                    <p class="fw-bold fs-5 m-0">洛神冰茶</p>
                    <div class="rating_stars my-1">
                      <a href="#" class="text-warning text-decoration-none">
                        <i class="fas fa-star"></i>
                      </a>
                      <a href="#" class="text-warning text-decoration-none">
                        <i class="fas fa-star"></i>
                      </a>
                      <a href="#" class="text-warning text-decoration-none">
                        <i class="fas fa-star"></i>
                      </a>
                      <a href="#" class="text-warning text-decoration-none">
                        <i class="fas fa-star"></i>
                      </a>
                      <a href="#" class="text-warning text-decoration-none">
                        <i class="fas fa-star"></i>
                      </a>
                    </div>
                    <p class="m-0">洛神味很讚讚</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

 <!-- Modal(sharecode) start-->
   <div class="modal fade" id="sharecode" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">分享你的邀請碼給好友吧</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body d-flex justify-content-center" style="padding-top: 30px;">
          <i class="fas fa-gift fa-lg"
            id="Invitationcode">&nbsp;&nbsp;&nbsp;&nbsp;${CLoginOK.invitation}&nbsp;</i>
          <button type="button" class="btn" style="position: relative;bottom: 9px;" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="right" data-bs-content="已複製">
            <i class="far fa-copy fa-lg" onclick="copy()"></i>
          </button>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn" data-bs-dismiss="modal" aria-label="Close">完成</button>
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
            <a href=""
              ><img src="<c:url value="/images/logo.png"/>" alt="logo" class="small-logo"
            /></a>
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
     <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value="/_05_Order/c_05_order/myOrder.js" />"></script>
   
  </body>
</html>
