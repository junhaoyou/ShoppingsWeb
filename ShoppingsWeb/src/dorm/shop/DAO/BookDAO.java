package dorm.shop.DAO;



import dorm.shop.javabean.Book;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * ClassName:BookDAO
 * Package:
 * Description:
 *
 * @Author:ziyou
 * @Create:2023/5/29 - 10:50
 * @Version:
 */
public interface BookDAO {
    void insert(Connection conn, Book book);
    /**
     *
     * @Description 针对指定的id，删除表中的一条记录
     * @author shkstart
     * @date 上午11:01:07
     * @param conn
     * @param
     */
    void deleteByName(Connection conn,String name);
    /**
     *
     * @Description 针对内存中的cust对象，去修改数据表中指定的记录
     * @author shkstart
     * @date 上午11:02:14
     * @param conn
     * @param
     */
    void update(Connection conn, Book book,String name);
    /**
     *
     * @Description 针对指定的id查询得到对应的Customer对象
     * @author shkstart
     * @date 上午11:02:59
     * @param conn
     * @param
     * @return
     */
    Book getCustomerById(Connection conn, int id);
    /**
     *
     * @Description 查询表中的所记录构成的集合
     * @author shkstart
     * @date 上午11:03:50
     * @param conn
     * @return
     */
    List<Book> getAll(Connection conn, String Search);
    /**
     *
     * @Description 返回数据表中的数据的条目数
     * @author shkstart
     * @date 上午11:04:44
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     *
     * @Description 返回数据表中最大的生日
     * @author shkstart
     * @date 上午11:05:33
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);

}
