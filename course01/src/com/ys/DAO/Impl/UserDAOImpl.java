package com.ys.DAO.Impl;

import com.ys.DAO.BaseDAO;
import com.ys.DAO.UserDAO;
import com.ys.bean.User;

import java.sql.Connection;
import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public List<User> getAll(Connection conn,String Search) {
        String sql = "select * from user where username ='"+Search+"'";
        List<User> list = getForList(conn, sql);
        return list;
    }
}
