   
//        $.ajax({  
//            type:"post", 
//            url:"http://localhost:8080/whattodrink/indexservlet",   
//            dataType:"json",
//            success:
//                function(data){  
//                    console.log(data);  
//                },  
//            error:
//                function(xhr, ajaxOptions, thrownError){
//                    alert(xhr.status+"\n"+thrownError);
//                }
//        });  



// 左右滑動設定
$(document).on("ready", function () {
  $(".regular").slick({
    dots: true,
    infinite: true,
    autoplay: true,
    speed: 1000,
    slidesToShow: 3,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1100,
        settings: {
          slidesToShow: 2,
          infinite: true,
        },
      },
      {
        breakpoint: 700,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
        },
      },
    ],
  });

  $(".regular1").slick({
    dots: true,
    infinite: true,
    autoplay: true,
    speed: 1000,
    slidesToShow: 4,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
          infinite: true,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
          infinite: true,
        },
      },
      {
        breakpoint: 380,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
        },
      },
    ],
  });

  $(".regular2").slick({
    infinite: true,
    slidesToShow: 11,
    slidesToScroll: 2,
    autoplay: false,
    speed: 1000,
    arrows: false,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 6,
          slidesToScroll: 2,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 5,
          slidesToScroll: 1,
        },
      },
      {
        breakpoint: 380,
        settings: {
          slidesToShow: 4,
          slidesToScroll: 1,
        },
      },
    ],
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

//顯示更多
//$("#more").click(function (e) {
//  $.ajax({
//    url: "",
//    type: "GET",
//    data: "",
//    success(res) {},
//  });
//});


// $(function() {
//   let storage = sessionStorage; 
//   let aa = document.getElementsByClassName('companyAddress');
//   console.log(aa.length);
//   for (var i=0; i<aa.length; i++) {
//     console.log(aa[i].value);
//     console.log(storage.getItem(i));
//     document.getElementById(parseInt(i+1)).innerText= `${storage.getItem(i)}公尺`;

// }


// });


// 我的最愛
function change(heart) {
console.log(heart.parentElement.parentElement.lastElementChild.previousElementSibling.value);
  if (heart.className == "far fa-heart fa-lg heart") {
  		console.log('空心轉實心');
   $.ajax({
            url: "https://whattodrink.herokuapp.com/AddDeleteMyFavoriteServlet",
            type: "post",
            data: {
              company_id:heart.parentElement.parentElement.lastElementChild.previousElementSibling.value
            },
            success(res) {
            console.log(res);
                heart.className = "fas fa-heart fa-lg heart";
              

            }});
  
  } else {
		console.log('實星轉空星');
   $.ajax({
     	
            url: "https://whattodrink.herokuapp.com/AddDeleteMyFavoriteServlet",
            type: "post",
            data: {
              company_id:heart.parentElement.parentElement.lastElementChild.previousElementSibling.value
            },
            success(res) {
             console.log(res);
                heart.className = "far fa-heart fa-lg heart";
            
            }
          });
  
  }
}

