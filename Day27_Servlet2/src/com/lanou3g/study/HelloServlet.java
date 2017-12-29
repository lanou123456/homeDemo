package com.lanou3g.study;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class HelloServlet extends HttpServlet {
    /*

    Tomcat就相当于一个简易版服务器
    我们可以把自己写的后端应用程序部署到Tomcat上
    然后就可以通过访问tomcat的方式去访问对应ip地址上的Tomcat

    那么我们创建好一个JavaWeb程序，并且部署到了Tomcat之后
    Tomcat是如何根据用户输入的地址，来知道我们程序的对应的执行单元呢？

    比如：192.168.20.122:8080/day16/ten

    这列这个day16就是要访问不是到Tomcat上，名为day16应用程序

    ten表示，要访问day16这个应用长须的那个文件？
    这里这个文件，实际上就是我们自己写的类，就是我们自定义的HttpServlet的子类

    也就是说：每次网路访问请求，实际都是在访问Servlet



    Servlet
    B/S系统   Browser Serverd
    C/S系统   Client Serverd



     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        /*
        Request和Response
        Request：请求，包含这次请求的说有数据
        Response：响应，将这次请求的结果返回给请求方

         */


        //使用req，获得请求参数，方法中传入的参数为：参数名
        //根据参数名获得参数值(类似键值对)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名为："+username+"\t"+"密码为："+password);

        System.out.println("已经访问到了Servlet");


        //使用resp，将请求的结果返回给请求方
        resp.getWriter().write("<h1>SUCCESS</h1>");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //500或500+表示服务器出错了
        //404表示为未找到资源，也就是你访问的路径，在服务器中不存在

        //解决post请求参数乱码问题
        resp.setCharacterEncoding("UTF-8");

        //获得请求参数
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        System.out.println("用户："+username);
        System.out.println("性别："+gender);

        //使用jdbc把数据插入到数据库
        //给用户一个结果
        resp.getWriter().write("INSERT SUCCESS") ;


    }
}
