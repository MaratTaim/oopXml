package com.newyear.present.candy.parser;

import com.newyear.present.candy.entity.Present;
import com.newyear.present.candy.impl.Candy;
import com.newyear.present.candy.impl.Fruit;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXParser implements Tags{
    private boolean countOfSugar = false;
    private boolean weight = false;
    private boolean size = false;
    private boolean season = false;
    private boolean boolCandy = false;
    private boolean boolFruit = false;
    private Present present;
    private Fruit fruit;
    private Candy candy;


    public Present getPresent() {
        return present;
    }

    public void parse(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void process(XMLStreamReader reader) throws XMLStreamException {
        String name;
        String endName;
        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    innerTags(name);
                    mainTags(name, reader);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    endName = reader.getLocalName();
                    switch (endName) {
                        case tagFruit:
                            boolFruit = false;
                            present.setList(fruit);
                            break;
                        case tagCandy:
                            boolCandy = false;
                            present.setList(candy);
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    writeText(reader.getText());
                    break;
            }
        }
    }

    private void mainTags(String name, XMLStreamReader reader) {
        switch (name) {
            case tagPresent:
                present = new Present();
                break;
            case tagCandy:
                candy = new Candy();
                candy.setType(reader.getAttributeValue(null, tagType));
                boolCandy = true;
                break;
            case tagFruit:
                fruit = new Fruit();
                fruit.setType(reader.getAttributeValue(null, tagType));
                boolFruit = true;
                break;
        }
    }


    public void innerTags(String name) {
        switch (name) {
            case tagCountOfSugar:
                countOfSugar = true;
                break;
            case tagWeight:
                weight = true;
                break;
            case tagSize:
                size = true;
                break;
            case tagSeason:
                season = true;
                break;
        }
    }

    public void writeText(String text) {
        if (countOfSugar && boolCandy) {
            candy.setCountOfShugar(Integer.parseInt(text.trim()));
            countOfSugar = false;
        }
        if (weight && boolCandy) {
            candy.setWeight(Float.parseFloat(text.trim()));
            weight = false;
        }
        if (countOfSugar && boolFruit) {
            fruit.setCountOfShugar(Integer.parseInt(text.trim()));
            countOfSugar = false;
        }
        if (weight && boolFruit) {
            fruit.setWeight(Float.parseFloat(text.trim()));
            weight = false;
        }

        if (size) {
            candy.setSize(text.trim());
            size = false;
        }
        if (season) {
            fruit.setSeason(text.trim());
            season = false;
        }
    }

}
