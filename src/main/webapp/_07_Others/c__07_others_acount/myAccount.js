// if (該用戶未輸入過邀請碼) {
//   document.getElementById("friendsharecode").disabled = false; // 變更欄位為可用
// } else {
//   document.getElementById("friendsharecode").value = 輸入過的邀請碼;
//   document.getElementById("friendsharecode").disabled = true; // 變更欄位為禁用
// }

let storage = sessionStorage;

//新增信用卡(驗證)
function plus() {
  let number = document.getElementById("cardnumber").value;
  let expirationdate = document.getElementById("expirationdate").value;

  if (number.length != 12 || expirationdate.length != 5) {
    alert("輸入資訊錯誤");
  } else {
    storage.setItem("cardnumber", number);
    $("#addcard").modal("hide");
    createCard();
  }
}
//動態新增新用卡
function createCard() {
  let bb = document.getElementById("bb");

  let newcard = document.createElement("div");
  newcard.className = "d-flex justify-content-center";

  bb.appendChild(newcard);

  let newspan = document.createElement("span");

  let image = document.createElement("img");
  image.src = "./image/credit-card.png";

  let i = document.createElement("i");
  i.className = "fas fa-times";
  i.style = "position: relative;left:20px;top: -23px";
  i.className += " delete";

  let title = document.createElement("h6");
  let finalnumber = storage.getItem("cardnumber").substring(8, 12);
  title.innerText = `-${finalnumber}`;

  newcard.appendChild(newspan);
  newspan.appendChild(image);
  newspan.appendChild(i);
  newspan.appendChild(title);

  delete11();
}

//刪除信用卡
function delete11() {
  let delete1 = document.querySelectorAll(".delete");
  console.log(delete1.length);
  for (let i = 0; i < delete1.length; i++) {
    delete1[i].addEventListener("click", (e) => {
      e.target.parentElement.parentElement.remove();
    });
  }
}

//載入頁面時監聽刪除button
window.addEventListener("load", function () {
  delete11();
});



// 複製邀請碼
function copy() {
  var content = document.getElementById("Invitationcode").innerText;
  navigator.clipboard
    .writeText(content)
    .then(() => {
      console.log("Text copied to clipboard...");
    })
    .catch((err) => {
      console.log("Something went wrong", err);
    });
}

//儲存地址

document.getElementById("location0").value = storage.getItem("Address");
document.getElementById("location1").value = storage.getItem("Address");

//按下enter送出定位表單
$("#location0").keydown(function (event) {
  if (event.keyCode == 13) {
    let Address = document.getElementById("location0").value;
    storage.setItem("Address", Address);
    document.getElementById("location0").value = storage.getItem("Address");
    document.getElementById("location1").value = storage.getItem("Address");
    $("locationform0").submit();
  }
});

$("#location1").keydown(function (event) {
  if (event.keyCode == 13) {
    let Address = document.getElementById("location1").value;
    storage.setItem("Address", Address);
    document.getElementById("location0").value = storage.getItem("Address");
    document.getElementById("location1").value = storage.getItem("Address");
    $("locationform1").submit();
  }
});

//複製邀請碼右方彈跳文字
var popoverTriggerList = [].slice.call(
  document.querySelectorAll('[data-bs-toggle="popover"]')
);
var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
  return new bootstrap.Popover(popoverTriggerEl);
});