package web;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.UserService;

import java.util.List;

public class UserAction  extends ActionSupport{
    private UserService userService = new UserService();
    public String query(){
        List<User> users = userService.get();
        ServletActionContext.getContext().put("users",users);
        return SUCCESS;
    }



}
