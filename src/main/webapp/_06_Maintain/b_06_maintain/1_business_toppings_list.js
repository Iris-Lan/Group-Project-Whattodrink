$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "https://whattodrink.herokuapp.com/UpdateToppingServlet",
    dataType: "json",
    success: function (response) {
      // console.log(response);
      renderHTML(response);
    },
  });
});
function renderHTML(data) {
  var str = "";
  for (let i = 0; i < data.length; i++) {
    str += `
        <div class="col-sm-4" >
          <div class="card mb-3">
            <div class="row">
              <div class="col-md-6">
                <img
                  class="ratio ratio-4x3"
                 src="../../${data[i].picPath}"
                />
              </div>
              <div class="col-md-6">
                <div class="card-body d-flex flex-column">
                  <div class="mb-4">
                    <h5 class="card-title">${data[i].toppingName}</h5>
                  </div>
                  <div
                    class="d-flex"
                    style="justify-content: space-between"
                  ><span class="d-none">${data[i].toppingId}</span>
                    <i
                      class="fas fa-edit"
                      role="button"
                    ></i>
                    <i class="fas fa-trash" role="button" id="delete"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      `;
  }
  $("#card").append(str);

  //刪除品項
  $("#delete").click(function (e) {
    // e.preventDefault();
    // console.log(e.target.parentElement.parentElement.parentElement.parentElement);-->card
    e.target.parentElement.parentElement.parentElement.parentElement.parentElement.remove();
    // console.log(e.target.parentElement.firstElementChild.innerText);-->proId
    //傳送被刪除的配料id
    $.ajax({
      type: "POST",
      url: "",
      data: {
        toppingId: e.target.parentElement.firstElementChild.innerText,
      },
      success: function (res) {
        $(`#${data[i].toppingId}`).remove();
      },
    });
  });

  // 開啟modal
  const modifyModal = document.getElementById("alter");
  const modal = new bootstrap.Modal(modifyModal, { keyboard: false });
  $(".fa-edit").click(function (e) {
    // console.log(e.target.previousElementSibling.innerText);
    var toppingId = e.target.previousElementSibling.innerText;
    //請求該配料資料
    $.ajax({
      type: "POST",
      url: "url",
      data: { toppingId: toppingId },
      success: function (response) {
        var toppingName = response.toppingName;
        var toppingPrice = response.toppingPrice;
        var toppingCal = response.toppingCal;
        $("#addOnName").text(toppingName);
        $("#addOnName").text(toppingPrice);
        $("#addOnName").text(toppingCal);
      },
    });

    $("#toppingId").attr("value", toppingId);
    console.log($("#toppingId"));
    modal.show();
  });
}

//傳送修改配料資訊
// $("button[type=submit]").click(function (e) {
//   e.preventDefault();
//   toppingName = $("#addOnName").val();
//   toppingPrice = $("#addOnName").val();
//   toppingCal = $("#addOnName").val();
//   $.ajax({
//     type: "POST",
//     url: "url",
//     data: {
//       toppingName: toppingName,
//       toppingPrice: toppingPrice,
//       toppingCal: toppingCal,
//     },
//     success: function (response) {
//       //資料庫收到資料傳1
//       if (response == 1) {
//         alert("更新成功");
//       }
//     },
//   });
// });
