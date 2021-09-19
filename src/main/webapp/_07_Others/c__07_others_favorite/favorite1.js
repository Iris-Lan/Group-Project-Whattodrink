
//動態移除
function change1(heart) {
  	
  	 console.log(heart.nextElementSibling.value);

   $.ajax({
            url: "https://whattodrink.herokuapp.com/AddDeleteMyFavoriteServlet",
            type: "post",
            data: {
              company_id : heart.nextElementSibling.value
            },
            success: function () {
              heart.parentElement.parentElement.remove();
            }})


          }


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

let storage = sessionStorage;
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
