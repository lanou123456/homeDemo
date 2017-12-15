package projectPractice.api.dataExchange;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetFirst {
    public static void main(String[] args) throws IOException, DocumentException {
        First();
    }
    public  static void  First() throws IOException, DocumentException {

        URL url = new URL("http://192.168.20.194:8080/day16/first");
        InputStream in=url.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        Document document = DocumentHelper.parseText(new String(b));

        SAXReader saxReader = new SAXReader();

        Element rootElement = document.getRootElement();
        Element nickname = rootElement.element("nickname");
        String text = nickname.getText();
        Element score = rootElement.element("score");
        String text1 = score.getText();
        System.out.println(text+"   "+text1);

    }
}
