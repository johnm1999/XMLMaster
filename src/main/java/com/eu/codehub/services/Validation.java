package com.eu.codehub.services;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class Validation {

    public void validateXsd(String xsdStringFile,String xmlStringFile){
        
        File xsdFile = new File(xsdStringFile);
        File xmlFile = new File(xmlStringFile);
    
        System.out.println("Validation Results: " + validateXMLSchema(xsdFile, xmlFile));  
        System.out.println("Validation Results: " + validateXMLSchema(new File("xsd_file/book.xsd"), new File("xml_file/sample-lorem-ipsum-text-file.xml")));
    }
    
     public static boolean validateXMLSchema(File xsdFile, File xmlFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        } catch (IOException | IllegalArgumentException | SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
