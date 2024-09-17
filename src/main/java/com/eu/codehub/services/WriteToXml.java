package com.eu.codehub.services;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WriteToXml {
    public void createXmlFromReadingList(List<Element> readingList, String outputFile) 
            throws TransformerConfigurationException, TransformerException {
    
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }

        Document newDoc = db.newDocument();

        Element bookElement = newDoc.createElement("book");
        newDoc.appendChild(bookElement);

        for (Element chapter : readingList) {
            Element chapterElement = newDoc.createElement("chapter");
            String id = chapter.getAttribute("id");
            chapterElement.setAttribute("id", id);

            bookElement.appendChild(chapterElement);

            NodeList paragraphs = chapter.getElementsByTagName("paragraph");
            for (int i = 0; i < paragraphs.getLength(); i++) {
                Node paragraphNode = paragraphs.item(i);

                Element paragraphElement = newDoc.createElement("paragraph");
                chapterElement.appendChild(paragraphElement);

                NodeList sentences = paragraphNode.getChildNodes();
                for (int j = 0; j < sentences.getLength(); j++) {
                    Node sentenceNode = sentences.item(j);
                    if (sentenceNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element sentenceElement = (Element) sentenceNode;
                        Element newSentenceElement = newDoc.createElement("sentence");
                        newSentenceElement.appendChild(newDoc.createTextNode(sentenceElement.getTextContent()));
                        paragraphElement.appendChild(newSentenceElement);
                    }
                }
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource source = new DOMSource(newDoc);
        StreamResult result = new StreamResult(new File(outputFile));

        transformer.transform(source, result);

        System.out.println("XML file created: " + outputFile);
    }
}
