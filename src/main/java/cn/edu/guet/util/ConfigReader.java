package cn.edu.guet.util;
/**
 * dom4j : dom for java
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class ConfigReader {
    public static void main(String[] args) throws ClassNotFoundException {
        getClassName();
    }
    public static String getClassName() throws ClassNotFoundException {
        InputStream in = Class.forName("cn.edu.guet.util.ConfigReader").getResourceAsStream("/config.xml");
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(in);
            Element element = (Element) document.selectObject("/animals/animal");
            return element.getStringValue();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
}
