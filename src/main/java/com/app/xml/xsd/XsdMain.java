package com.app.xml.xsd;

import org.Dependency;
import org.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class XsdMain {

    public static void main(String[] args) throws Exception {
        XsdOperations operations = new XsdOperations();
        URL url = XsdMain.class.getResource("/com/xml/pom.xml");
        String filePath = url.getFile();
        InputStream in = new FileInputStream(new File(filePath));
        byte[] data = new byte[in.available()];
        in.read(data);
        String xml = new String(data);
        Model model=operations.fromXml(xml);
        List<Dependency> dependencies = model.getDependencies().getDependency();
        for(Dependency dependency:dependencies){
            System.out.println(dependency.getGroupId());
            System.out.println(dependency.getArtifactId());
            System.out.println(dependency.getVersion());
            System.out.println("----------------------------------------");
        }
        xml=operations.toXml(model);
        System.out.println(xml);
    }
}
