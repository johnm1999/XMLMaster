package com.eu.codehub.services;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromXml {

    public List<Element> ReadXmlChapter(String inputFile, List<Integer> selectedChapters) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Element> readingList = new ArrayList<>();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(inputFile));

            System.out.println("Root Element:" + doc.getDocumentElement().getNodeName());
            System.out.println("----------------------");

            NodeList chapterList = doc.getElementsByTagName("chapter");

            System.out.println("Size of list:" + chapterList.getLength());
            System.out.println("----------------------");

            for (int i = 0; i < chapterList.getLength(); i++) {
                Node nodeChapter = chapterList.item(i);
                Element elementChapter = (Element) nodeChapter;
                try {
                    int id = Integer.parseInt(elementChapter.getAttribute("id"));

                    if (selectedChapters.contains(id)) {
                        readingList.add(elementChapter);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID format for Chapter " + (i + 1) + ": " + elementChapter.getAttribute("id"));
                }

            }
            System.out.println("Total Chapters:" + readingList.size());

        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
        return readingList;
    }
}
