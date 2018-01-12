package com.app.xml.mapping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Cats {
    private List<Cat> cats;

//    public List<Cat> getCats() {
//        return cats;
//    }

    @XmlElement(name = "cat")
    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public List<Cat> getCats() {
        return cats;
    }
}
