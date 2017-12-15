package projectPractice.api.dataExchange;

import projectPractice.loginAndRegister.Person;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Send {
//    public static void main(String[] args) throws IOException {
//       ReSend();
//    }
    public static void  ReSend(Person person,long time) throws IOException {
       URL url = new URL("http://192.168.20.194:8080/day16/insert?username="+person.getUsername()+"&score="+time);
        InputStream in=url.openStream();
        byte[] buff =new byte[1024];
        int len = in.read(buff);
        System.out.println(new String(buff,0,len));

    }
}
