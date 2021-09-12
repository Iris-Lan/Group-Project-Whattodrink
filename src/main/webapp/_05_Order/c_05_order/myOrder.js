//訂單完成時間
$('#check').click(function (e) {
    const options2 = {
        hour12: false,
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit"
    }
    var d2 = new Date().toLocaleTimeString("en-US", options2);

    let d = new Date();
    let yyyy = new Intl.DateTimeFormat('default', { year: 'numeric' }).format(d);
    let MM = new Intl.DateTimeFormat('default', { month: 'numeric' }).format(d);
    let dd = new Intl.DateTimeFormat('default', { day: '2-digit' }).format(d);

    var day=`${yyyy}-${MM}-${dd} ${d2}`;

    // 後端接時間的()
    $.ajax({
        url:"",
        type:"POST",
        data:{time:day},
    })
});
//領取狀態
$.ajax({
    url:"",
    type:"GET",
    data:"",
    success(res){},
});



//顯示更多
$("#more").click(function (e) {
    $.ajax({
      url: "",
      type: "GET",
      data: "",
      success(res) {},
    });
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


  
  
  