package book.service;

import book.dao.BookDao;
import book.domain.Book;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDao();

    @Test
    public List<Book> category(String cid) throws SQLException {
        if (cid.equals("0")) {
            List<Book> all = bookDao.findAll();
            return all;
        }
        List<Book> cate = bookDao.findCate(cid);
        return cate;
    }

    public Book bloadSer(String bid) throws SQLException {
        Book book = bookDao.BidLoad(bid);
        return book;
    }


}