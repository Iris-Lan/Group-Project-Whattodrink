//收藏愛心
function change(heart) {
console.log(heart.id);
  if (heart.className == "far fa-heart fa-lg") {
  		console.log('空心轉實心');
   $.ajax({
            url: "https://whattodrink.herokuapp.com/AddDeleteMyFavoriteServlet",
            type: "post",
            data: {
              company_id:heart.id
            },
            success(res) {
            console.log(res);
                heart.className = "fas fa-heart fa-lg";
              

            }});
  
  } else {
		console.log('實星轉空星');
   $.ajax({
     	
            url: "https://whattodrink.herokuapp.com/AddDeleteMyFavoriteServlet",
            type: "post",
            data: {
              company_id:heart.id
            },
            success(res) {
             console.log(res);
                heart.className = "far fa-heart fa-lg heart";
            
            }
          });
  
  }
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