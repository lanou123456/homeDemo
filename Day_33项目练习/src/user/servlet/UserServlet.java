package user.servlet;

import cart.daomain.CartItem;
import cart.servlet.CartServlet;
import user.daomain.User;
import user.service.UserService;
import user.service.exception.loginException.LoginException;
import user.service.exception.registerException.RegisterException;
import user.uti.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();
    private User form = new User();
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            request.removeAttribute("user");
            BeanUtils.populate(form,parameterMap);
            String ud = userService.Ud();
            form.setCode(ud);
            request.setAttribute("user",form);

            userService.register(form);
            userService.sendEmail(form.getEmail(),form.getCode());



            request.getSession().setAttribute("username",form.getUsername());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RegisterException e) {
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request,response);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {

            BeanUtils.populate(form,parameterMap);
            request.setAttribute("username",form.getUsername());
            request.setAttribute("password",form.getPassword());

            System.out.println(form+"----------------------");

            userService.login(form);


            request.getSession().setAttribute("user",form);
            String uid = userService.findUid(form);
            request.getSession().setAttribute("uid",uid);
            Map<String,CartItem> map = new HashMap<String,CartItem>();
            request.getSession().setAttribute("cart",map);

            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("Refere")==null) {
            String code = request.getParameter("code");
            try {
                userService.active(code);
                userService.state(code);
                request.setAttribute("success", "激活成功！");
              request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (RegisterException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);
            }
        }else {



        }
    }
}
