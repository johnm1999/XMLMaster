package com.eu.codehub.services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/***
 * JAXB
 * Exceptions 
 * @author John
 */
public class GenerateXsdFromModel {

    public  void generator(Class<?> clazz, String outputPath){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

            // Create XSD
            jaxbContext.generateSchema(new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName){
                    File file = new File(outputPath);
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.getAbsolutePath());
                    return result;
                }
            });
            System.out.println("Successfully XSD Creation: " + outputPath);

        } catch (JAXBException e) {
            System.err.println("Exception JAXB: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Can't create XSD: " + e.getMessage());
        }

    }
}
