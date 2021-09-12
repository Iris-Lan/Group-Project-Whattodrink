$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/whattodrink/PaymentDiscount",
    dataType: "json",
    async:false,
    success: function (response) {
      var sub_total = response.sub_total;
      $("#total").text(sub_total);
      if (response.hasDiscount != 0) {
        $("#discount").removeClass("d-none");
        $("input[name=invitationDiscount]").change(function () {
          $("#counting").addClass("d-none");
          if ($("input[value=yes]").is(":checked") == true) {
            $("#counting").removeClass("d-none");
            $("#sub_total").text(sub_total);
            $("#total").text(sub_total - 50);
          } else {
            $("#counting").addClass("d-none");
            $("#total").text(sub_total);
          }
        });
      }
    },
  });

  $("button[type=submit]").click(function (e) {
    e.preventDefault();
    var payment = $("input[name=payment]:checked").val();
    var taxId = $("#taxId").val();
    var discount = $("input[ name=invitationDiscount]:checked").val();
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/whattodrink/_05_Order/preConfirmOrderServlet",
      data: {
        payment: payment,
        taxId: taxId,
        invitationDiscount: discount,
      },
      success: function(){
      	window.location.assign("http://localhost:8080/whattodrink/_04_ShoppingCart/confirmOrderPage.jsp");
      }
    });
  });
});
