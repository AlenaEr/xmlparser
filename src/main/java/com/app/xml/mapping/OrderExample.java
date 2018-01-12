package com.app.xml.mapping;

import java.util.List;

public interface OrderExample {
    public String toXml(Order order);

    public Order fromXml(String xml);

    public String toXml(List<Order> orders);

    public List<Order> fromListXml(String xml);
}
