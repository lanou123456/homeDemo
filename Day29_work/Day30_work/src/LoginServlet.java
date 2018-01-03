import dao.Data;
import dao.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        Data data = new Data();
        try {
            BeanUtils.populate(user,parameterMap);
            User query = data.Query(user);
            if ((query.getUsername()).equals(user.getUsername())){
                        if ((query.getPassword()).equals(user.getPassword())){
                            getServletContext().setAttribute("user",user);
                            request.getRequestDispatcher("/index.jsp")
                                    .forward(request,response);
                            return;
                        }else {
                            System.out.println("密码错误！");
                        }


            }else {
                System.out.println("用户名不存在！");
            }

response.sendRedirect("http://localhost:8080/login.html");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
