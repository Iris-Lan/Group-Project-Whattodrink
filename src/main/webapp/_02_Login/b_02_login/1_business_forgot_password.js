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
    "constrains",
    function (value, element) {
      return (
        this.optional(element) ||
        (value.length >= 8 &&
          /^[A-Za-z0-9]+$/.test(value) &&
          /[a-z]/g.test(value) &&
          /[A-Z]/g.test(value))
      );
    },
    "密碼需為英文大小寫及數字，至少8碼"
  );

  $.validator.addMethod(
    "noEmail",
    function (value, element) {
      $.ajax({
        type: "POST",
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

  $("#input_email").validate({
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

  $("variviedCode").validate({
    // onsubmit: false,
    rules: {
      variviedCode: {
        required: true,
      },
    },
    messages: {
      variviedCode: {
        required: "請輸入驗證碼",
      },
    },
  });

  $("#resetPassword").validate({
    password: {
      required: true,
      constrains: true,
    },
    password2: {
      required: true,
      equalTo: "#password",
    },
    messages: {
      password: {
        required: "請輸入密碼",
      },
      password2: {
        required: "請輸入密碼",
        equalTo: "密碼不一致，請重新輸入",
      },
    },
  });

  $("#next").submit(function (e) {
    e.preventDefault();
    $ajax({
      url: "",
      type: "POST",
      data: $("#input_email").serialize(),
      success(res) {
        $("#input_email").removeClass("d-none");
        $("#variviedCode").addClass("flex");
        $("#resetPassword").removeClass("d-none");
      },
    });
    // 2分鐘後重寄驗證碼
    setTimeout(function () {
      $("#resend").removeClass("d-none");
    }, 120000);
  });

  $("#next2").submit(function (e) {
    e.preventDefault();
    $ajax({
      url: "",
      type: "POST",
      data: $("#variviedCode").serialize(),
      success(res) {
        $("#input_email").removeClass("d-none");
        $("#variviedCode").removeClass("d-none");
        $("#resetPassword").addClass("flex");
      },
    });
  });

  $("#resetPassword").submit(function () {
    $ajax({
      url: "",
      type: "POST",
      data: {
        password: function () {
          return $("#password").validate();
        },
      },
      success(res) {
        alert("更新成功，回到登入頁");
      },
    });
  });
});
