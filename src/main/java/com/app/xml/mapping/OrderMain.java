package com.app.xml.mapping;

public class OrderMain {
    public static void main(String[] args) {
        OrderExample order = new OrderImpl();
        Order od = new Order();
        od.setName("n1");
        od.setCity("City");
        od.setState("state");
        od.setStreet("street");
        od.setZip("");
        String xml = order.toXml(od);
        System.out.println(xml);
        order.fromXml(xml);
        System.out.println(od);

    }
}
