package web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class Login extends ActionSupport {
    private String uname;
    private String password;
    public String login(){
        if (uname.equals("admin")){
            ServletActionContext.getRequest().getSession().setAttribute("user",uname);
            return  SUCCESS;
        }

       return "login";

    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
