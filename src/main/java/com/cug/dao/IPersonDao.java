package com.cug.dao;

import com.cug.bean.Person;

public interface IPersonDao {

    Person selectUserByAccount(String uid, String password);

    Integer insertUserByAccount(String uid, String userName, String userPassword);

    Integer selectUserByUid(String uid);
}
