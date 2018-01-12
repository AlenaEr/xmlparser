package com.app.xml.mapping;

import java.util.List;

public interface Transformer {

    public String toXml(Cat cat);

    public Cat fromXml(String xml);

    public String toXml(List<Cat> cat);

    public List<Cat> fromBulkXml(String xml);
}
