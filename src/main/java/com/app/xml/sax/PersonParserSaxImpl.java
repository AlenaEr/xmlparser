package com.app.xml.sax;

import com.app.common.Person;
import com.app.xml.PersonParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PersonParserSaxImpl implements PersonParser {


    public List<Person> getPersons() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        final List<Person> personList = new ArrayList();
        try {
            SAXParser parser = factory.newSAXParser();
            URL url = getClass().getResource("/com/xml/persons.xml");
            String xmlFile = url.getFile();
            parser.parse(xmlFile, new DefaultHandler(){
                private Person person;
                private String currentOpenTag;

                @Override
                public void startDocument() throws SAXException {
                   System.out.println("START DOCUMENT");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if("person".equalsIgnoreCase(qName)){
                        person = new Person();
                    }
                    currentOpenTag=qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                   if(value.trim().length()!=0) {
                       if ("name".equalsIgnoreCase(currentOpenTag)) {
                           person.setName(value);
                       } else if ("age".equalsIgnoreCase(currentOpenTag)) {
                            int age = Integer.parseInt(value);
                            person.setAge(age);
                       }
                   }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                   // currentOpenTag=null;
                    if("person".equalsIgnoreCase(qName)){
                        personList.add(person);
                    }
                    //currentOpenTag=null;
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("END DOCUMENT");
                }
            });
            return personList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
