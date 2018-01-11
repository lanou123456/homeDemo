package cart.servlet;

import book.domain.Book;
import book.service.BookService;
import cart.daomain.CartItem;
import user.uti.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "servlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookService();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("count");
        System.out.println(count);
        String bid = request.getParameter("bid");
        System.out.println(bid);
        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        System.out.println(cart);
        try {
            Book book = bookService.bloadSer(bid);
          CartItem cartItem = new CartItem(count,book);
                cart.put(bid,cartItem);

            request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
                        cart.clear();
request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
    }


    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        cart.remove(bid);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
    }


}
