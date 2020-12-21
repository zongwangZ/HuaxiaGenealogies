package com.cug.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 这是一个以斜杠开头的相对路径，出现在后台 Java 代码中，所以是一个后台路径
        *
        * 一般情况下，后天路径的参照路径为 Web 应用的根路径
        *
        * 但是 response.sendRedirect() 方法是一个特例，其参照路径为 Web 服务器的根路径
        * 所以，在此需要加上项目名称，项目名称可以通过 request.getContextPath 获得
        * */
        resp.sendRedirect(req.getContextPath() + "/html/login.jsp");
    }
}
