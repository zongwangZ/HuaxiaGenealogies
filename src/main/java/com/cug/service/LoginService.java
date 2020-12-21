package com.cug.service;

import com.cug.bean.Person;
import com.cug.dao.IPersonDao;
import com.cug.dao.PersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        String uid = req.getParameter("userId");
        String password = req.getParameter("userPassword");

        // 2. 验证参数合法性

        // 3. 调用 DAO 层查找数据库
        IPersonDao personDao = new PersonDaoImpl();
        Person person = personDao.selectUserByAccount(uid, password);


        // 4. 做出响应

        /*
        * resp.setContentType("text/html");
        * resp.setCharacterEncoding("UTF-8");
        *
        * 等价于
        *
        * resp.setContentType("text/html;charset=UTF-8");
        * */
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if(person != null){
            out.print("登陆成功!<br>");
            out.print("用户身份证号：" + person.getUid() + "<br>");
            out.print("用户姓名：" + person.getName() + "<br>");
            out.print("用户密码：" + person.getPassword() + "<br>");
        }else{
            out.print("抱歉！改用户不存在！");
        }
        out.flush();
    }
}
