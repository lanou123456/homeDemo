package util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginStatusinterceptor extends MethodFilterInterceptor {
//    @Override
//    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
//        if (user!=null){
//            actionInvocation.invoke();
//        }
//
//return "fail";
//
//    }

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user!=null){
            actionInvocation.invoke();
            return "successs";
        }

        return "fail";
    }
}
