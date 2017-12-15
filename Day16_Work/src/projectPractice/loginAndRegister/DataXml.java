package projectPractice.loginAndRegister;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DataXml {


    public static void Data(Person person) throws DocumentException, IOException {

//        Document document1 = DocumentHelper.createDocument();
        SAXReader saxReader = new SAXReader();
       Document document = saxReader.read(new File("src/data.xml"));

        if (document.getRootElement() ==null){
         Element element = document.addElement("Person");
       }
//        Element person1 = document1.addElement("Person");
        Element rootElement = document.getRootElement();
        Element element = rootElement.addElement("data");
        Element element1 = element.addAttribute("name",person.getName());
        Element element2 = element1.addElement("username");
        Element element3 = element2.addText(person.getUsername());
        Element element4 = element.addElement("password");
        Element element5 = element4.addText(person.getPassword());

       OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/data.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
