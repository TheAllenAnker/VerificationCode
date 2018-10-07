package com.allen_anker.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String expectedCode = (String) request.getSession().getAttribute("kcode");
        if (code != null && expectedCode != null) {
            if (code.equalsIgnoreCase(expectedCode)) {
                out.print("success");
            } else {
                out.print("fail");
            }
        } else {
            out.print("fail");
        }
        out.flush();
        out.close();
    }
}
