package dorm.shop.DAO;

import dorm.shop.DAO.BaseDAO;
import dorm.shop.DAO.BookDAO;
import dorm.shop.javabean.Book;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * ClassName:BookDAOImpl
 * Package:
 * Description:
 *
 * @Author:ziyou
 * @Create:2023/5/29 - 10:51
 * @Version:
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public void insert(Connection conn, Book book) {

        String sql = "insert into book_msg values(?,?,?,?,?,?,?,?,?)";
        update(conn,sql,book.getId(),book.getAuthor(),book.getPrice());
    }




    @Override
    public void deleteByName(Connection conn, String name) {
        String sql = "delete from book_msg where bookName = ? ";
        update(conn,sql,name);
    }

    @Override
    public void update(Connection conn, Book book,String name) {
        String sql = "update book_msg set bookID =?,bookName =?,bookPublisher =?,bookAuthor =?,bookPrice =?,borrowTime =?,backTime =?,bookSum =?,bookCount =? where bookName ='"+name+"' ";
        //update(conn,sql,book.getBookID(),book.getBookName(),book.getBookAuthor(),book.getBookPrice());
    }

    @Override
    public Book getCustomerById(Connection conn, int id) {
        return null;
    }


    @Override
    public List<Book> getAll(Connection conn, String Search) {
        String sql = "select bookID,bookName,bookPublisher,bookAuthor,bookPrice,borrowTime,backTime,bookSum,bookCount from book_msg where bookName = '"+Search+"'";
        List<Book> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        return null;
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        return null;
    }

}
