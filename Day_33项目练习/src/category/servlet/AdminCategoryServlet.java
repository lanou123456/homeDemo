package category.servlet;

import category.domain.Category;
import category.service.CategoryService;
import category.service.exception.HasBooksException;
import user.uti.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/adminCategory")
public class AdminCategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryService();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String cname = request.getParameter("cname");

        String encode = URLEncoder.encode(cname, "iso-8859-1");
        String cname1 = URLDecoder.decode(encode, "utf-8");


//        System.out.println(cname+"---------------");
        try {
            categoryService.add(cname1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        findAll(request,response);
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> cnList = categoryService.catSer();
            request.setAttribute("catename",cnList);
            request.getRequestDispatcher("/adminjsps/admin/category/list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String cid = request.getParameter("cid");
        try {
            categoryService.delete(cid);
        } catch (HasBooksException e) {
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request,response);
        }
        findAll(request,response);


    }



}
