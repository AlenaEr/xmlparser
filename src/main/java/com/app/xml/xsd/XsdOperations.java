package com.app.xml.xsd;

import org.Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class XsdOperations {

    public String toXml(Model model){
        try{
            JAXBContext context = JAXBContext.newInstance(Model.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String xml = null;
            try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
                marshaller.marshal(model, out);
                xml = new String(out.toByteArray());
            }
            return xml;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Model fromXml(String xml){
        try{
            JAXBContext context = JAXBContext.newInstance(Model.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Model model = null;
            try(ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes())) {
                model= ((JAXBElement<Model>) unmarshaller.unmarshal(in)).getValue();
            }
            return model;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
