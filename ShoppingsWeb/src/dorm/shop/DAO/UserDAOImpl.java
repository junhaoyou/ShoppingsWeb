package dorm.shop.DAO;

import dorm.shop.javabean.Book;
import dorm.shop.javabean.User;

import java.sql.Connection;
import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {


    @Override
    public void insert(Connection conn, Book book) {

    }

    @Override
    public void deleteByName(Connection conn, String name) {

    }

    @Override
    public void insert(com.mysql.jdbc.Connection conn, User user) {

    }

    @Override
    public List<User> getAll(com.mysql.jdbc.Connection conn, String Search) {
        return null;
    }
}
