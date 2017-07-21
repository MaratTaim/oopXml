package com.newyear.present.candy.parser;

import com.newyear.present.candy.entity.Present;
import com.newyear.present.candy.impl.Candy;
import com.newyear.present.candy.impl.Fruit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Created by User on 29.06.2017.
 *
 * I will tray to parse XML file
 * I stop on 21:21
 */
public class DOMParser implements Tags{
    private Candy candy;
    private Fruit fruit;
    private Present present;


    public Present getPresent(){
        return present;
    }

    public void parse(Document doc) {
        try {
            NodeList candyList = doc.getElementsByTagName(tagCandy);
            present = new Present();
            for (int i = 0; i < candyList.getLength(); i++) {
                Node node = candyList.item(i);
                candy = new Candy();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    candy.setType(element.getAttribute(tagType));
                    candy.setCountOfShugar(Integer.parseInt(element.getElementsByTagName(tagCountOfSugar).item(0).getTextContent()));
                    candy.setWeight(Float.parseFloat(element.getElementsByTagName(tagWeight).item(0).getTextContent()));
                    candy.setSize(element.getElementsByTagName(tagSize).item(0).getTextContent());
                }
                present.setList(candy);
            }
            NodeList fruitList = doc.getElementsByTagName(tagFruit);
            for (int i = 0; i < fruitList.getLength(); i++) {
                Node node = fruitList.item(i);
                fruit = new Fruit();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    fruit.setType(element.getAttribute(tagType));
                    fruit.setCountOfShugar(Integer.parseInt(element.getElementsByTagName(tagCountOfSugar).item(0).getTextContent()));
                    fruit.setWeight(Float.parseFloat(element.getElementsByTagName(tagWeight).item(0).getTextContent()));
                    fruit.setSeason(element.getElementsByTagName(tagSeason).item(0).getTextContent());
                }
                present.setList(fruit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
