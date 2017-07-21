package com.newyear.present.candy.parser;

import com.newyear.present.candy.entity.Present;
import com.newyear.present.candy.impl.Candy;
import com.newyear.present.candy.impl.Fruit;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXParser extends DefaultHandler implements Tags{
    boolean countOfSugar = false;
    boolean weight = false;
    boolean size = false;
    boolean season = false;
    boolean boolCandy = false;
    boolean boolFruit = false;
    Present present;
    Fruit fruit;
    Candy candy;

    public Present getPresent() {
        return present;
    }

    @Override
    public void startElement(String uri, String localName, String tag, Attributes attr) throws SAXException {
        switch (tag) {
            case tagPresent:
                present = new Present();
            case tagCandy:
                candy = new Candy();
                candy.setType(attr.getValue(tagType));
                boolCandy = true;
                break;
            case tagCountOfSugar:
                countOfSugar = true;
                break;
            case tagWeight:
                weight = true;
                break;
            case tagSize:
                size = true;
                break;
            case tagFruit:
                fruit = new Fruit();
                fruit.setType(attr.getValue(tagType));
                boolFruit = true;
                break;
            case tagSeason:
                season = true;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (countOfSugar && boolCandy) {
            candy.setCountOfShugar(Integer.parseInt(new String(ch, start, length)));
            countOfSugar = false;
        }
        if (weight && boolCandy) {
            candy.setWeight(Float.parseFloat(new String(ch, start, length)));
            weight = false;
        }
        if (countOfSugar && boolFruit) {
            fruit.setCountOfShugar(Integer.parseInt(new String(ch, start, length)));
            countOfSugar = false;
        }
        if (weight && boolFruit) {
            fruit.setWeight(Float.parseFloat(new String(ch, start, length)));
            weight = false;
        }

        if (size) {
            candy.setSize(new String(ch, start, length));
            size = false;
        }
        if (season) {
            fruit.setSeason(new String(ch, start, length));
            season = false;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case tagCandy:
                boolCandy = false;
                present.setList(candy);
                break;
            case tagFruit:
                boolFruit = false;
                present.setList(fruit);
                break;
        }
    }


}