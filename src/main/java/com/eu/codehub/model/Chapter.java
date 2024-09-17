package com.eu.codehub.model;
    
import jakarta.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Chapter {

    @XmlAttribute // Προσθήκη του ID ως XML attribute
    private int id;
    private List<Paragraph> paragraphs = new ArrayList<>();
}
