package com.cug.dao;

import com.cug.bean.Person;
import com.cug.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements IPersonDao {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet resultSet;


    public Person selectUserByAccount(String uid, String password) {
        Person person = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from person where uid=? and password=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setUid(resultSet.getString("uid"));
                person.setName(resultSet.getString("name"));
                person.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.close(connection, ps, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return person;
    }
}