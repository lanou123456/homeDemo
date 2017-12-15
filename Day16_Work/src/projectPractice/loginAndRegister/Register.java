package projectPractice.loginAndRegister;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    public static int  Reg(Person person) throws IOException, DocumentException {
        boolean flag1 =true;
        String a="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        String b="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern regex1 = Pattern.compile(a);
        Pattern regex2 = Pattern.compile(b);
        Matcher matcher1 = regex1.matcher(person.getUsername());
        Matcher matcher2 = regex2.matcher(person.getUsername());
        flag1 = matcher1.matches()|matcher2.matches();
        if(flag1==false ){
            System.out.println("用户名格式不对！");
return 2;
        }




        Pattern regex = Pattern.compile("^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])).{4,16}$");
        Matcher matcher = regex.matcher(person.getPassword());
        boolean flag = matcher.matches();
        if(flag==false){
            System.out.println("密码格式不对！");
return 2;
        }
        if (flag1==true && flag==true){

            System.out.println("注册成功！");
DataXml.Data(person);
return 1;
        }
return 0;
    }




}
