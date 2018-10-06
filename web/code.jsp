<%--
  Created by IntelliJ IDEA.
  User: Fenyr_Allen
  Date: 2018-10-06
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.allen_anker.code.CodeUtils" %>
<%
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
    response.setHeader("expires", "0");

    String code = CodeUtils.drawImage(response);
    request.setAttribute("code", code);

    out.clear();
    out = pageContext.pushBody();
%>