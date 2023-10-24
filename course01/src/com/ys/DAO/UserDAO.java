package com.ys.DAO;

import com.ys.bean.User;

import java.sql.Connection;
import java.util.List;

public interface UserDAO {
    List<User> getAll(Connection conn,  String Search);
}
