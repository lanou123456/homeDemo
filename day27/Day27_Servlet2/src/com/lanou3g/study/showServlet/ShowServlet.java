package com.lanou3g.study.showServlet;

import com.lanou3g.study.util.Query;
import com.lanou3g.study.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ShowServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String age = req.getParameter("age");
        String loc = req.getParameter("loc");
        Connection con = JdbcUtil.getConnection();
        try {
            int query = new Query().update(
                    con, "insert  into hw_user values(null,?,?,?) ",
                    uname, age, loc
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
            resp.getWriter().write("SOCCESS");
    }
}
