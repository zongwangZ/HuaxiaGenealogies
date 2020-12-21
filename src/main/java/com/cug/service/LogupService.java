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

public class LogupService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        req.setCharacterEncoding("UTF-8");

        // 获取注册表单中的参数
        String uid = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        String userPasswordConfirm = req.getParameter("userPasswordConfirm"); // 其实密码确认，可以由 js 完成

        // 验证参数的正确性

        // 判断数据库中是否已经存在该用户
        IPersonDao personDao = new PersonDaoImpl();
        Integer id = personDao.selectUserByUid(uid);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if(id != null){
            out.print("该用于已经存在！请直接登陆或者使用新账号重新注册！");
            out.flush();
            return;
        }

        // 如果不存在，则插入该用户，返回受影响的行数
        Integer integer = personDao.insertUserByAccount(uid, userName, userPassword);

        // 做出响应
        out.print("注册成功！");
        out.print(integer);
        out.flush();
    }
}
