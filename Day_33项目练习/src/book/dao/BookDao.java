package book.dao;

import book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import user.uti.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
private QueryRunner qr= new QueryRunner();
private   Connection connection = JdbcUtil.getConnection();
    public List<Book> findAll() throws SQLException {
        String sql = "select * from book";
        List<Book> query = qr.query(connection, sql, new BeanListHandler<Book>(Book.class));
        return query;
    }

    public List<Book> findCate(String cid) throws SQLException {
//        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from book where cid=?";
        List<Book> query = qr.query(connection, sql, new BeanListHandler<Book>(Book.class), cid);
        return query;

    }

    public Book BidLoad(String bid ) throws SQLException {
//        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from book where bid=?";
        Book query = qr.query(connection, sql, new BeanHandler<Book>(Book.class), bid);
        return query;
    }



}
