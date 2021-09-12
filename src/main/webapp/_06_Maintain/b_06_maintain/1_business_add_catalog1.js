//載入頁面時請求後端資料
$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/whattodrink/AddCategoryServlet",
    dataType: "json",
    success: function (response) {
     // console.log(response);
     // $("#name1").val(response.name1);
     // $("#name2").val(response.name2);
     // $("#name3").val(response.name3);
     // $("#name4").val(response.name4);
     // $("#name5").val(response.name5);
      //動態新增顯示在右邊
      //var show_result = `
     // <span>${response.name1}</span></br>
     // <span>${response.name2}</span></br>
     // <span>${response.name3}</span></br>
     // <span>${response.name4}</span></br>
     // <span>${response.name5}</span></br>`;
     // result.insertAdjacentHTML("afterbegin", show_result);
    },
  });
});

//傳分類給後端
$("#send").click(function (e) {
   e.preventDefault();
  var name1 = $("#name1").val();
  var name2 = $("#name2").val();
  var name3 = $("#name3").val();
  var name4 = $("#name4").val();
  var name5 = $("#name5").val();
  $.ajax({
    url: "http://localhost:8080/whattodrink/AddCategoryServlet",
    data: {
      name1: name1,
      name2: name2,
      name3: name3,
      name4: name4,
      name5: name5,
    },
    type: "POST",
     success(res) {
       //動態新增顯示在右邊
       var show_result = `
       <span id="show_result">${res.name1}</span></br>
       <span id="show_result">${res.name2}</span></br>
       <span id="show_result">${res.name3}</span></br>
       <span id="show_result">${res.name4}</span></br>
       <span id="show_result">${res.name5}</span></br>`;
       result.insertAdjacentHTML("afterbegin", show_result);
     },
  });
});
