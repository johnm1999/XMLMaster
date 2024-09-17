package com.eu.codehub;

import com.eu.codehub.services.ReadFromXml;
import com.eu.codehub.services.WriteToXml;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Element;

public class XMLProcessing {

    public static void main(String[] args) throws Exception {

//        Use Case: Txt to Xml parser
//        TxtToXmlParser toXmlParser = new TxtToXmlParser();
//        toXmlParser.txtToXmlConvert("xml_file/sample-lorem-ipsum-text-file.txt", "xml_file/sample-lorem-ipsum-text-file.xml");


//       --------------------------------------------------------------         


//       Use Case : Read from Parent Xml
//        ReadFromXml readAndWriteFromXml = new ReadFromXml();
//        List<Integer> selectedChapters = Arrays.asList(3,4,5,9);
//        readAndWriteFromXml.ReadXmlChapter("xml_file/sample-lorem-ipsum-text-file.xml",selectedChapters );


//       --------------------------------------------------------------   


//        Use Case : Write to xml file
//        First read then write it 
        ReadFromXml readAndWriteFromXml = new ReadFromXml();
        List<Integer> selectedChapters = Arrays.asList(3, 4, 5, 9);
        List<Element> newElementList = readAndWriteFromXml.ReadXmlChapter("xml_file/sample-lorem-ipsum-text-file.xml", selectedChapters);

        WriteToXml writeToXml = new WriteToXml();
        writeToXml.createXmlFromReadingList(newElementList, "xml_file/selected-chapters.xml");

    }
}
