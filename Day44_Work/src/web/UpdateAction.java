package web;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import service.UserService;

public class UpdateAction extends ActionSupport implements ModelDriven<User> {
private UserService userService = new UserService();
private User user = new User();
private int id;
    public String update(){
        String sid = ServletActionContext.getRequest().getParameter("id");
        int id = Integer.parseInt(sid);
        User user = userService.get1(id);
        ServletActionContext.getContext().put("user",user);
        return SUCCESS;
    }


    public String update1(){
userService.update(user);


        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public User getModel() {
        return user;
    }
}
