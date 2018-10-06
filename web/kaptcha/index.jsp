<%--
  Created by IntelliJ IDEA.
  User: Fenyr_Allen
  Date: 2018-10-06
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kaptcha Demo</title>
</head>
<body>
<form action="submit.action">
    <input type="text" name="kaptcha" value="">
    <image src="http://localhost:8080/VerificationCode/kaptcha.jpg"></image>
</form>
</body>
</html>
