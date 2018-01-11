//package user.uti;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "SessionFilter",urlPatterns = {"/index.jsp"})
//public class SessionFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        Object username = request.getSession().getAttribute("user");
//        if (username!=null){
//            chain.doFilter(req, resp);
//            return;
//        }
//        //重定向要加上项目名
//        response.sendRedirect(request.getContextPath()+"/jsps/msg.jsp");
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
