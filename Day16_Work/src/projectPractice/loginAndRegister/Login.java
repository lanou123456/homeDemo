package projectPractice.loginAndRegister;

import org.dom4j.DocumentException;

import java.util.List;

public class Login {
    public static Person login(String username,String password) throws DocumentException {
        List<Person> person =  DataLogin.Login();
       int count=1;
        for (Object o : person){

            Person person1 = (Person) o;
            if(username.equals(person1.getUsername())  && password.equals(person1.getPassword())){
                count =2;
           System.out.println("登录成功!");
           return  person1;
//

            }

        }
return null;

    }

}
