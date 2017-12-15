package projectPractice.loginAndRegister;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import projectPractice.loginAndRegister.Person;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class UserNameJudge {
public static void Judge(Person person) throws DocumentException {
    SAXReader saxReader = new SAXReader();
    Document document = saxReader.read(new File("src/data.xml"));
    Element rootElement = document.getRootElement();
    List elements = rootElement.elements("data");
    for (Iterator it = elements.iterator(); it.hasNext(); ) {
        Element elm = (Element) it.next();
        String username = elm.elementText("username");
        



    }
}


}
