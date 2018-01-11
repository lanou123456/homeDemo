package book.servlet;

import book.domain.Book;
import book.service.BookService;
import user.uti.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookService();
    public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String bid = request.getParameter("bid");
        Book book = bookService.bloadSer(bid);
        request.setAttribute("books",book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request,response);
    }

    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String category = request.getParameter("cid");

            List<Book> bookList = bookService.category(category);

            request.setAttribute("book",bookList);
            request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);


    }
}
