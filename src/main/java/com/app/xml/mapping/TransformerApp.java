package com.app.xml.mapping;

import java.util.ArrayList;
import java.util.List;

public class TransformerApp {

    public static void main(String[] args) {
        Transformer transformer = new TransformerImpl();
        Cat cat = new Cat();
        cat.setAge(1);
        cat.setName("Cat1");
        cat.setColor("White");
        String xml=transformer.toXml(cat);
        System.out.println(xml);
        cat=transformer.fromXml(xml);
        System.out.println(cat);
        System.out.println("----------------------");
        List<Cat> cats = new ArrayList();
        for(int i=0;i<3;i++){
            Cat item = new Cat();
            cats.add(item);
            item.setColor("C"+i);
            item.setName("N"+i);
            item.setAge(i);
        }
        xml = transformer.toXml(cats);
        System.out.println(xml);
        cats=transformer.fromBulkXml(xml);
        for(Cat catItem: cats){
            System.out.println(catItem);
        }
    }
}
