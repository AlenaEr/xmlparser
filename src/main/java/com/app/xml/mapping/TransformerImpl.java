package com.app.xml.mapping;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class TransformerImpl implements Transformer {

    public String toXml(Cat cat) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            String xml = null;
            try(ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                marshaller.marshal(cat, out);
                byte[] data = out.toByteArray();
                xml = new String(data);
            }

            return xml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Cat fromXml(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Cat cat = null;
            try(ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());) {
                cat = (Cat) unmarshaller.unmarshal(in);
            }
            return cat;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toXml(List<Cat> cats) {
        try {
            Cats catsObject = new Cats();
            catsObject.setCats(cats);
            JAXBContext context = JAXBContext.newInstance(Cats.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            String xml = null;
            try(ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                marshaller.marshal(catsObject, out);
                byte[] data = out.toByteArray();
                xml = new String(data);
            }
            return xml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cat> fromBulkXml(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cats.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Cats cats = null;
            try(ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());) {
                cats = (Cats) unmarshaller.unmarshal(in);
            }
            return cats.getCats();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
