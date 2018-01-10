package com.app.xml.sax;

import com.app.common.Person;
import com.app.xml.PersonParser;
import com.app.xml.dom.PersonPareserDomImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonParserSaxImplTest  {
    private PersonParser personParser;

    @Before
    public void init(){
       // personParser = new PersonParserSaxImpl();
        personParser = new PersonPareserDomImpl();
    }

    @Test
    public void parserTest(){
        List<Person> persons = personParser.getPersons();
        assertTrue("size="+persons.size(), persons.size()==3);
        Person p0=persons.get(0);
        assertNotNull(p0);
        assertEquals("Piter", p0.getName());
        assertEquals(40, p0.getAge());
        Person p1=persons.get(1);
        assertEquals("Jack", p1.getName());
        assertEquals(35, p1.getAge());
        Person p2=persons.get(2);
        assertEquals("Boris", p2.getName());
        assertEquals(25, p2.getAge());
    }


}
