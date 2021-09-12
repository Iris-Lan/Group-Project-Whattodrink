$(function () {
  $.validator.setDefaults({
    errorClass: "help-block",
    highlight: function (element) {
      $(element).closest(".form-control-lg").addClass("has-error");
    },
    unhighlight: function (element) {
      $(element).closest(".form-control-lg").removeClass("has-error");
    },
  });

  $.validator.addMethod(
    "noEmail",
    function (value, element) {
      $.ajax({
        type: "GET",
        url: "",
        data: $("#email").serialize(),
        dataType: "json",
        success: function (res) {
          if (res == "yes") {
            return false;
          }
        },
      });
    },
    `無此信箱，請聯繫<a class="text-decoration-none" href="mailto:whattodrink2021@whattodrink.com">今天喝什麼</a>`
  );

  $("#getUsername").validate({
    // onsubmit: false,
    rules: {
      email: {
        required: true,
        email: true,
        noEmail: true,
      },
    },
    messages: {
      email: {
        required: "請輸入信箱",
        email: "信箱格式錯誤，須包含@與.com",
        remote: "noEmail",
      },
    },
  });

  $("#next").submit(function (e) {
    e.preventDefault();
    $ajax({
      url: "",
      type: "POST",
      data: {},
      success(res) {
        const email = document.getElementById("email");
        const btn = document.getElementById("next");
        const back = document.getElementById("back");
        btn.addEventListener("click", function (e) {
          e.preventDefault();
          email.style.display = "none";
          back.style.display = "block";
        });
      },
    });
  });
});
