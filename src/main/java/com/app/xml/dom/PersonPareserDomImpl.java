package com.app.xml.dom;

import com.app.common.Person;
import com.app.xml.PersonParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PersonPareserDomImpl implements PersonParser {

    public List<Person> getPersons() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Person> persons = new ArrayList<Person>();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            URL url=getClass().getResource("/com/xml/persons.xml");
            String fileName=url.getFile();
            Document document = documentBuilder.parse(fileName);
            Element element = document.getDocumentElement();
            NodeList list = element.getChildNodes();
            for(int i=0;i<list.getLength();i++){

                Node personNode = list.item(i);
                if(personNode.getNodeType()== Node.ELEMENT_NODE) {
                /*NodeList personNodeItem = personNode.getChildNodes();
                for(int j=0;j<personNodeItem.getLength();j++){
                    Node name
                }*/
                    Element elementPerson = (Element) personNode;
                    String name=elementPerson.getElementsByTagName("name").item(0).getTextContent();
                    String ageValue = elementPerson.getElementsByTagName("age").item(0).getTextContent();
                    Person p = new Person();
                    p.setName(name);

                    p.setAge(Integer.parseInt(ageValue));
                    persons.add(p);
                }
            }


            return persons;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        new PersonPareserDomImpl().getPersons();
    }
}
