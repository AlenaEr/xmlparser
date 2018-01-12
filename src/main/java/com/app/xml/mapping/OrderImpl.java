package com.app.xml.mapping;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class OrderImpl implements OrderExample {


    @Override
    public String toXml(Order order) {
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String xml = null;
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                marshaller.marshal(order, out);
                byte[] data = out.toByteArray();
                xml = new String(data);
            }

            return xml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order fromXml(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Order order = null;
            ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
            order = (Order) unmarshaller.unmarshal(is);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String toXml(List<Order> orders) {
        return null;
    }

    @Override
    public List<Order> fromListXml(String xml) {
        return null;
    }
}
