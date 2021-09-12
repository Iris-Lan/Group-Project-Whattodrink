$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "https://whattodrink.herokuapp.com/UpdateProductServlet",
    dataType: "json",
    success: function (response) {
      // console.log(response);
      renderHTML(response);
    },
  });
});
function renderHTML(data) {
  var str = "";
  for (let i = 0; i < 12; i++) {
    str += `
        <div class="col-sm-4" id="${data[i].proId}">
          <div class="card mb-3">
            <div class="row">
              <div class="col-md-6">
                <img
                  class="ratio ratio-4x3"
                  src="https://picsum.photos/400/300/?blur=2"
                />
              </div>
              <div class="col-md-6">
                <div class="card-body d-flex flex-column">
                  <div class="mb-4">
                    <h5 class="card-title">${data[i].proName}</h5>
                  </div>
                  <div
                    class="d-flex"
                    style="justify-content: space-between"
                  ><span class="d-none">${data[i].proId}</span>
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
  // $("#delete").click(function (e) {
  //   e.preventDefault();
  //   // console.log(e.target.parentElement.parentElement.parentElement.parentElement);-->card
  //   // console.log(e.target.parentElement.firstElementChild.innerText);-->proId
  //   $.ajax({
  //     type: "POST",
  //     url: "order_history.json",
  //     data: {
  //       proId: e.target.parentElement.firstElementChild.innerText,
  //     },
  //     success: function (res) {
  //       $(`#${data[i].proId}`).remove();
  //     },
  //   });
  // });
  //顯示更多
  $("#more").click(function () {
    var str2 = "";
    for (let i = 12; i < data.length; i++) {
      str2 += `
          <div class="col-sm-4">
            <div class="card mb-3">
              <div class="row">
                <div class="col-md-6">
                  <img
                    class="ratio ratio-4x3"
                    src="https://picsum.photos/400/300/?blur=2"
                  />
                </div>
                <div class="col-md-6">
                  <div class="card-body d-flex flex-column">
                    <div class="mb-4">
                      <h5 class="card-title">${data[i].proName}</h5>
                    </div>
                    <div
                      class="d-flex"
                      style="justify-content: space-between"
                    >
                      <i
                        class="fas fa-edit"
                        role="button"
                      ></i>
                      <i class="fas fa-trash" role="button"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    `;
    }
    $("#card").append(str2);
    $("#more").hide();
    $("#delete").click(function (e) {
      e.preventDefault();
      // console.log(e.target.parentElement.parentElement.parentElement.parentElement);-->card
      // console.log(e.target.parentElement.firstElementChild.innerText);-->proId
      $.ajax({
        type: "POST",
        url: "order_history.json",
        data: {
          proId: e.target.parentElement.firstElementChild.innerText,
        },
        success: function (res) {
          $(`#${data[i].proId}`).remove();
        },
      });
    });
  });
  const modifyModal = document.getElementById("alter");
  const modal = new bootstrap.Modal(modifyModal, { keyboard: false });
  $(".fa-edit").click(function (e) {
    // console.log(e.target.previousElementSibling.innerText);
    var proId = e.target.previousElementSibling.innerText;
    $.ajax({
      type: "POST",
      url: "url",
      data: { proId: proId },
      success: function (response) {
        var name = response.addOnName;
        var total = response.addOnTotal;
        var cal = response.addOnCal;
        $("#addOnName").val(name);
        $("#addOnName").val(total);
        $("#addOnName").val(cal);
      },
    });
    modal.show();
  });
}
