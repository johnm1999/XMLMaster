package com.eu.codehub.services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class GenerateXsdFromModel {

    public  void generator(Class<?> clazz, String outputPath){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

            // Create XSD
            jaxbContext.generateSchema(new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    File file = new File(outputPath);
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.getAbsolutePath());
                    return result;
                }
            });
            System.out.println("Το XSD schema δημιουργήθηκε επιτυχώς στο: " + outputPath);

        } catch (JAXBException e) {
            System.err.println("Σφάλμα κατά την επεξεργασία του JAXB: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την εγγραφή του XSD αρχείου: " + e.getMessage());
        }

    }
}
