package com.eu.codehub.services;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class TxtToXmlParser {

    /**
     * Create chapters with ID.
     *
     * @param inputFile   
     * @param outputFile  
     * @throws Exception  
     * 
     */
    public void txtToXmlConvert(String inputFile, String outputFile) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(inputFile)).stream()
                .filter(line -> !line.trim().isEmpty()) // Filter lines
                .collect(Collectors.toList());

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlWriter = new IndentingXMLStreamWriter(xmlOutputFactory.createXMLStreamWriter(new FileWriter(outputFile)));

        xmlWriter.writeStartDocument("UTF-8", "1.0");
        xmlWriter.writeStartElement("book");

        int chapterCount = (lines.size() + 19) / 20;
        int paragraphCount = 0;
        int sentenceCount = 0;
        int wordCount = 0;

        Set<String> distinctWords = new HashSet<>();

        for (int i = 0; i < chapterCount; i++) {
            xmlWriter.writeStartElement("chapter");
            xmlWriter.writeAttribute("id", String.valueOf(i + 1)); 

            int startLine = i * 20;
            int endLine = Math.min(startLine + 20, lines.size());

            for (int j = startLine; j < endLine; j++) {
                String paragraphText = lines.get(j).trim();
                xmlWriter.writeStartElement("paragraph");

                String[] sentences = paragraphText.split("\\.\\s*");
                for (String sentenceText : sentences) {
                    if (!sentenceText.isEmpty()) {
                        xmlWriter.writeStartElement("sentence");
                        xmlWriter.writeCharacters(sentenceText.trim() + ".");
                        xmlWriter.writeEndElement(); // close sentence

                        sentenceCount++;

                        // Calculate Distinct Words
                        String[] words = sentenceText.trim().split("\\s+");
                        wordCount += words.length;
                        distinctWords.addAll(Arrays.asList(words));
                    }
                }

                xmlWriter.writeEndElement(); 
                paragraphCount++;
            }

            xmlWriter.writeEndElement(); 
        }

        xmlWriter.writeStartElement("statistics");

        writeSimpleElement(xmlWriter, "paragraphCount", String.valueOf(paragraphCount));
        writeSimpleElement(xmlWriter, "sentenceCount", String.valueOf(sentenceCount));
        writeSimpleElement(xmlWriter, "wordCount", String.valueOf(wordCount));
        writeSimpleElement(xmlWriter, "distinctWordCount", String.valueOf(distinctWords.size()));
        writeSimpleElement(xmlWriter, "creationDate", LocalDateTime.now().toString());
        writeSimpleElement(xmlWriter, "authorName", "John Morellas");
        writeSimpleElement(xmlWriter, "className", "Book");
        xmlWriter.writeEndElement(); 

        xmlWriter.writeEndElement(); 
        xmlWriter.writeEndDocument();

        xmlWriter.close();

        System.out.println("Το XML αρχείο δημιουργήθηκε με επιτυχία: " + outputFile);
    }

    private static void writeSimpleElement(XMLStreamWriter writer, String elementName, String elementValue) throws Exception {
        writer.writeStartElement(elementName);
        writer.writeCharacters(elementValue);
        writer.writeEndElement();
    }
}
