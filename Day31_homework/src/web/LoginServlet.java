package web;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "web.LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
            User u = userDao.match(user.getUsername());
            if (u != null) {
                if (user.getPassword().equals(u.getPassword())) {

                    HttpSession session = request.getSession();
                    session.setAttribute("username", user.getUsername());

//                    response.addHeader("Set-Cookie",u.getUsername());
                    Cookie cookie = new Cookie("username",user.getUsername());
                        cookie.setMaxAge(60*60*24*30);
                        response.addCookie(cookie);

                    request.getRequestDispatcher("/index.jsp").forward(request, response);

                } else {
                    System.out.println("密码错误");
                }

                response.sendRedirect("/login.jsp");
        }else {
                System.out.println("找不到用户名");
                response.sendRedirect("/login.jsp");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = cookies[0];
        response.getWriter().write(cookie.toString());
    }
}
