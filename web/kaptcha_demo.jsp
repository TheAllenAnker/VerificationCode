<%--
  Created by IntelliJ IDEA.
  User: Fenyr_Allen
  Date: 2018-10-07
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test for Kaptcha</title>
    <style>#codeInput{height: 36px;}</style>
</head>
<body>
<form action="">
    <p>
        <input type="text" name="kaptcha" id="codeInput" maxlength="5"
               placeholder="Please enter the verification code.">
        <image src="http://localhost:8080/VerificationCode/kaptcha.jpg" id="changeCode"></image>
    </p>
    <p>
        <input type="button" id="login" value="Login">
    </p>
    <div id="result">What?</div>
</form>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        $("#changeCode").on("click", function () {
            $(this).attr("src", "http://localhost:8080/VerificationCode/kaptcha.jpg?d=" + new Date().getTime());
        });
        $("#login").on("click", function () {
            var code = $("#codeInput").val();
            var params = {"code": code};
            $.post("http://localhost:8080/VerificationCode/LoginServlet", params, function (data) {
                if (data === "success") {
                    $("#result").html("Success");
                } else {
                    $("#result").html("Fail");
                    $("#codeInput").val("").focus();
                }
            }, "text");
        });
    });
</script>
</body>
</html>
