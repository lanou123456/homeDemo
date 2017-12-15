package projectPractice.loginAndRegister;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataLogin {
    public static List<Person> Login() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/data.xml"));
        Element rootElement = document.getRootElement();
        List elements = rootElement.elements("data");

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            Person person = new Person();
            Element elm = (Element) elements.get(i);
            Element username = elm.element("username");
            String text = username.getText();
            person.setUsername(text);
            Element password = elm.element("password");
            String text1 = password.getText();
            person.setPassword(text1);
            Attribute name = elm.attribute("name");
            String nameText = name.getText();
            person.setName(nameText);
            list.add(person);


        }
return list;
    }
}


