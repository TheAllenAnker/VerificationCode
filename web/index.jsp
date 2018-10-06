<%--
  Created by IntelliJ IDEA.
  User: Fenyr_Allen
  Date: 2018-10-06
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Verification Code</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<img src="code.jsp" id="codeImg1">
<a href="javascript:void(0);" onclick="changeCode1()">Change Code</a>
<br>
<img src="code2.jsp" id="codeImg2">
<a href="javascript:void(0);" onclick="changeCode2()">Change Code</a>
<script>
    function changeCode1() {
        document.getElementById("codeImg1").src = "code.jsp?d=" + new Date().getTime();
    }

    function changeCode2() {
        document.getElementById("codeImg2").src = "code2.jsp?d=" + new Date().getTime();
    }
</script>
</body>
</html>
