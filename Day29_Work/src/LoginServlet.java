import Dao.Data;
import Dao.User;
import Dao.util.JdbcUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    Data data =new Data();
        String query=null;
        try {
             query= data.Query(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (query !=null){
            response.getWriter().write("success");

        }else {
            response.sendRedirect("http://localhost:8080/login.html");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
