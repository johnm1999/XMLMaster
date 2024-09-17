package com.eu.codehub;

import com.eu.codehub.model.Book;
import com.eu.codehub.services.GenerateXsdFromModel;
import com.eu.codehub.services.ReadFromXml;
import com.eu.codehub.services.StatisticsOfXmlFile;
import com.eu.codehub.services.TxtToXmlParser;
import com.eu.codehub.services.Validation;
import java.util.Arrays;
import java.util.List;
import lombok.Locked.Read;

public class XMLProcessing {

    public static void main(String[] args) throws Exception {

//         - Use Case: Txt to Xml parser

//        TxtToXmlParser toXmlParser = new TxtToXmlParser();
//        toXmlParser.txtToXmlConvert("xml_file/sample-lorem-ipsum-text-file.txt", "xml_file/sample-lorem-ipsum-text-file.xml");


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

        Validation v = new Validation();
        v.validateXsd("xsd_file/book.xsd", "xml_file/sample-lorem-ipsum-text-file.xml");


    }
}
