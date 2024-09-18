package com.eu.codehub.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class StatisticsOfXmlFile {
    /***
     * 
     * @param inputFile 
     * You can see fields that hold the statistics(paragraphs,sentences,etc)
     * Line by Line Reading
     * Nodes to hold every list 
     * 
     */
    public void statisticsXml(String inputFile) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        int paragraphs = 0;
        int sentences = 0;
        int wordCount = 0;
        Set<String> uniqueWords = new HashSet<>();
        String author = "John Morellas";
        String dateOfCreation = LocalDateTime.now().toString();
        String className = this.getClass().getSimpleName();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(inputFile));

            NodeList chapterList = doc.getElementsByTagName("chapter");
            for (int i = 0; i < chapterList.getLength(); i++) {
                Node chapterNode = chapterList.item(i);
                if (chapterNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element chapterElement = (Element) chapterNode;
                    NodeList paragraphList = chapterElement.getElementsByTagName("paragraph");
                    paragraphs += paragraphList.getLength();
                    for (int j = 0; j < paragraphList.getLength(); j++) {
                        Element paragraphElement = (Element) paragraphList.item(j);
                        NodeList sentenceList = paragraphElement.getElementsByTagName("sentence");
                        sentences += sentenceList.getLength();
                        for (int k = 0; k < sentenceList.getLength(); k++) {
                            Element sentenceElement = (Element) sentenceList.item(k);
                            String sentenceText = sentenceElement.getTextContent();
                            String[] words = sentenceText.split("\\s+");
                            wordCount += words.length;
                            for (String word : words) {
                                uniqueWords.add(word.toLowerCase());
                            }
                        }
                    }
                }
            }

            System.out.println("Statistics From XML:");
            System.out.println("----------------------------------");
            System.out.println("Total Paragraphs:" + paragraphs);
            System.out.println("Total Sentences:" + sentences);
            System.out.println("Total Words:" + wordCount);
            System.out.println("Unique Words:" + uniqueWords.size());
            System.out.println("Author:" + author);
            System.out.println("Creation Date:" + dateOfCreation);
            System.out.println("Class Name:" + className);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
