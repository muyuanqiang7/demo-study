package com.funi.muyq.demo.study.pattern.factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 10:24]
 */
public class XMLUtil {
    public static String getCarType() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(XMLUtil.class.getClassLoader().getResourceAsStream("car-config.xml"));
            NodeList nodeList = document.getElementsByTagName("carType");
            Node node = nodeList.item(0).getFirstChild();
            return node.getNodeValue().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
