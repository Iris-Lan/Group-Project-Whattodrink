$("#sub").click(function(){
    $.post(
        "./JSP/parameter.jsp",
        $("#forgetpassword1").serialize(),
        function (res) {
          $("#warntext").html(res);
          if(res==null){
              java發送驗證信
          }
        })

});


