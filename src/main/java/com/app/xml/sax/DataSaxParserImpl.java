package com.app.xml.sax;

import com.app.common.Person;
import com.app.common.Phone;
import com.app.xml.DataParser;
import com.app.xml.PersonParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataSaxParserImpl implements DataParser {
    public List<Phone> getPhones() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        final List<Phone> phoneList = new ArrayList<Phone>();
        try {
            SAXParser parser = factory.newSAXParser();
            URL url = getClass().getResource("/com/xml/data.xml");
            String xmlFile = url.getFile();
            parser.parse(xmlFile, new DefaultHandler() {
                private Phone phone;
                private String currentOpenTag;

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("START DOCUMENT");
                }

                @Override
                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {
                    if ("phone".equalsIgnoreCase(qName)) {

                        phone = new Phone();
                        phone.setManufactor(attributes.getValue("manufactor"));
                    }
                    currentOpenTag = qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    if (value.trim().length() != 0) {
                        if ("manufactor".equalsIgnoreCase(currentOpenTag)) {
                            phone.setManufactor(value);
                        } else if ("title".equalsIgnoreCase(currentOpenTag)) {
                            String title = String.valueOf(value);
                            phone.setTitle(title);

                        } else if ("price".equalsIgnoreCase(currentOpenTag)) {
                            int price = Integer.parseInt(value);
                            phone.setPrice(price);
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("phone")) {
                        phoneList.add(phone);
                    }
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("END DOCUMENT");
                }
            });

            return phoneList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
