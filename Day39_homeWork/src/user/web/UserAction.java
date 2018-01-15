package user.web;

import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserService;
import user.service.loginException.LoginException;
import user.service.registerException.UserHasException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public class UserAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    private User user  = new User();
    private UserService userService = new UserService();
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

public  String  register()  {

    Map<String, String[]> parameterMap = request.getParameterMap();
    try {
        BeanUtils.populate(user,parameterMap);
          userService.register(user);

    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (UserHasException e) {
        request.setAttribute("error",e.getMessage());
        return "register";

    } catch (SQLException e) {
        e.printStackTrace();
    }

return "register";
}


public  String login(){
    Map<String, String[]> parameterMap = request.getParameterMap();
    try {
        BeanUtils.populate(user,parameterMap);
        userService.login(user);

    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (LoginException e) {
        request.setAttribute("error",e.getMessage());
        return "login";
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "login";

}



}
