package dao;

import domain.Book;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BookDao {
    private QueryRunner qr = new QueryRunner();

    public void Insert(Book book){
        String sql = "insert into book values(?,?,?)";
        Connection conn = null;

        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,book.getBkname(),book.getAuthor(),book.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);

    }

    public Book Query(String bkname) {
        String sql = "select * from book where bkname=?";
        Connection conn = JdbcUtil.getConnection();
        Book book = new Book();
        try {
            book=qr.query(conn,sql,new BeanHandler<Book>(Book.class),bkname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;

    }
    public Book QueryAll() {
        String sql = "select * from book ";
        Connection conn = JdbcUtil.getConnection();
        Book book = new Book();
        try {
            book=qr.query(conn,sql,new BeanHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;

    }
}
