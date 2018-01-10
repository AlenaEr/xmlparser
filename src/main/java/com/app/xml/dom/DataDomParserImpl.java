package com.app.xml.dom;

import com.app.common.Phone;
import com.app.xml.DataParser;
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

public class DataDomParserImpl implements DataParser {

    public List<Phone> getPhones() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Phone> phoneList = new ArrayList<Phone>();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
            URL url = getClass().getResource("/com/xml/data.xml");
            String file = url.getFile();
            Document document = documentBuilder.parse(file);
            Element el = document.getDocumentElement();
            NodeList nodeList = el.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node phoneNode = nodeList.item(i);
                if (phoneNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementPhone = (Element) phoneNode;
                    String manufactor = elementPhone.getAttribute("manufactor");
                    String title = elementPhone.getElementsByTagName("title").item(0).getTextContent();
                    String price = elementPhone.getElementsByTagName("price").item(0).getTextContent();
                    Phone ph = new Phone();
                    ph.setManufactor(manufactor);
                    ph.setTitle(title);
                    ph.setPrice(Integer.parseInt(price));
                    phoneList.add(ph);
                }
            }

            return phoneList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
