package order.servlet;

import book.domain.Book;
import cart.daomain.CartItem;
import order.dao.OrderDao;
import order.domain.Order;
import order.service.OrderService;
import order.service.exception.OrderStateException;
import user.daomain.User;
import user.uti.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String sum = request.getParameter("sum");

        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        String time = orderService.time();
        String oid = orderService.oid();
        String uid = (String) request.getSession().getAttribute("uid");
        Order order = new Order(oid,time,sum,uid);
        orderService.add(order);
        orderService.addItem(cart,oid);
            request.setAttribute("time",time);
            request.setAttribute("oid",oid);
            request.setAttribute("sum",sum);
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);


    }

    public void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String uid = (String) request.getSession().getAttribute("uid");
        User user = (User) request.getSession().getAttribute("user");
        List<Order> myOrder = orderService.findByUid(uid);
        request.setAttribute("myOrder",myOrder);
        request.getRequestDispatcher("/jsps/order/list.jsp").forward(request,response);
    }



    public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        cart.clear();
        String oid = request.getParameter("oid");
        Order orderByOid = orderService.findOrderByOid(oid);
        request.setAttribute("oid",oid);
        request.setAttribute("time",orderByOid.getOrdertime());
        request.setAttribute("sum",orderByOid.getPrice());
        request.setAttribute("orderByOid",orderByOid);
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);

    }


    public void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String oid = request.getParameter("oid");
        try {
            orderService.getStateByOid(oid);
            request.setAttribute("error","确认成功，交易完成！");
        } catch (OrderStateException e) {
           request.setAttribute("error",e.getMessage());
           request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
        }


    }





}
