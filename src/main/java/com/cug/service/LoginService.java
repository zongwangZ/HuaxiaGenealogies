package com.cug.service;

import com.cug.bean.Person;
import com.cug.dao.IPersonDao;
import com.cug.dao.PersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if(person != null){
            System.out.println(person);
        }else{
            System.out.println("该用户不存在");
        }
        // 4. 将用户信息写入 Session，并跳转到首页

    }
}
