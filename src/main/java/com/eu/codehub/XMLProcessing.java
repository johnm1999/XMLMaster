package com.eu.codehub;

import com.eu.codehub.model.Book;
import com.eu.codehub.services.GenerateXsdFromModel;
import com.eu.codehub.services.ReadFromXml;
import com.eu.codehub.services.StatisticsOfXmlFile;
import com.eu.codehub.services.TxtToXmlParser;
import com.eu.codehub.services.Validation;
import com.eu.codehub.services.WriteToXml;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import lombok.Locked.Read;
import org.w3c.dom.Element;

public class XMLProcessing {

    public static void main(String[] args) throws Exception {

//         - Use Case: Txt to Xml parser
       
//        TxtToXmlParser toXmlParser = new TxtToXmlParser();
//        try {
//            toXmlParser.txtToXmlConvert("xml_file/sample-lorem-ipsum-text-file.txt", "xml_file/sample-lorem-ipsum-text-file.xml");
//        } catch (IOException e) {
//            System.err.println("Read or Write Exception: " + e.getMessage());
//        } catch (XMLStreamException e) {
//            System.err.println("Can't Create XML File: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Exception: " + e.getMessage());
//        }

//       --------------------------------------------------------------         
//        - Use Case : Read from Parent Xml
//        ReadFromXml readAndWriteFromXml = new ReadFromXml();
//        List<Integer> selectedChapters = Arrays.asList(3,4,5,9);
//        readAndWriteFromXml.ReadXmlChapter("xml_file/sample-lorem-ipsum-text-file.xml",selectedChapters );
//       --------------------------------------------------------------   
//         - Use Case : Write to xml file
//        First read then write it 
//        ReadFromXml readAndWriteFromXml = new ReadFromXml();
//        List<Integer> selectedChapters = Arrays.asList(3, 4, 5, 9);
//        List<Element> newElementList = readAndWriteFromXml.ReadXmlChapter("xml_file/sample-lorem-ipsum-text-file.xml", selectedChapters);
//
//        WriteToXml writeToXml = new WriteToXml();
//        writeToXml.createXmlFromReadingList(newElementList, "xml_file/selected-chapters.xml");
//       --------------------------------------------------------------   
//         - Use Case: Generate Statistics From XML file
//        StatisticsOfXmlFile soxf = new StatisticsOfXmlFile();
//        soxf.statisticsXml("xml_file/sample-lorem-ipsum-text-file.xml");
//       --------------------------------------------------------------   
//         - Use Case: Generate Statistics From XML file
//        GenerateXsdFromModel xsdFromModel = new GenerateXsdFromModel();
//        xsdFromModel.generator(Book.class, "xsd_file/book.xsd");
//        System.out.println("XSD scema generated successfully!!");
//       --------------------------------------------------------------   
//         - Use Case: Generate Statistics From XML file
//        Validation v = new Validation();
//        v.validateXsd("xsd_file/book.xsd", "xml_file/sample-lorem-ipsum-text-file.xml");
    }
}
