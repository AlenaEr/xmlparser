package com.app.xml.sax;

import com.app.common.Phone;
import com.app.xml.DataParser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataParserSaxTest {
    private DataParser dataParser;
    @Before
    public void init(){
        dataParser=new DataSaxParserImpl();
    }
    @Test
    public void saxParserSaxTest(){
        List<Phone>phoneList=dataParser.getPhones();
        assertTrue("size="+phoneList.size(), phoneList.size()==3);
        Phone p0=phoneList.get(0);
        assertEquals("Firma1", p0.getManufactor());
        System.out.println(p0.getManufactor());
        System.out.println(phoneList.get(1));
        System.out.println(phoneList.get(2));
    }

}
