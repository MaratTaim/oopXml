package com.newyear.present.candy.runner;

import com.newyear.present.candy.entity.Present;
import com.newyear.present.candy.parser.DOMParser;
import com.newyear.present.candy.parser.SAXParser;
import com.newyear.present.candy.parser.StAXParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static Present present;
    private static Present present2;
    private static Present present3;
    private static final String file = "file.xml";

    public static void main(String[] args) {

       try {
           //------------StAX parser--------------
           StAXParser parser = new StAXParser();
           InputStream input = new FileInputStream(file);
           parser.parse(input);
           present = parser.getPresent();

           //------------SAX parser---------------
           SAXParserFactory factory = SAXParserFactory.newInstance();
           javax.xml.parsers.SAXParser parser2 = factory.newSAXParser();
           SAXParser myPars = new SAXParser();
           parser2.parse(new FileInputStream(file),myPars);
           present2 = myPars.getPresent();

           //------------DOM parser---------------
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(new FileInputStream(file));
           DOMParser parser3 = new DOMParser();
           parser3.parse(doc);
           present3 = parser3.getPresent();

           System.out.println(present.equals(present2));
           System.out.println(present2.equals(present3));

       } catch (ParserConfigurationException | IOException | SAXException e) {
           e.printStackTrace();
       }
    }
}
