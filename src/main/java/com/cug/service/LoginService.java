package com.cug.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数

        // 2. 验证参数合法性

        // 3. 调用 DAO 层查找数据库

        // 4. 将用户信息写入 Session，并跳转到首页
    }
}
