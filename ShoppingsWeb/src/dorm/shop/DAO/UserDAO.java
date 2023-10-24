package dorm.shop.DAO;
import com.mysql.jdbc.Connection;
import dorm.shop.javabean.User;

import java.util.List;

public interface UserDAO {
	 void insert(Connection conn, User user);
	  List<User> getAll(Connection conn, String Search);
}
