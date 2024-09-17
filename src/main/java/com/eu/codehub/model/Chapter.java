package com.eu.codehub.model;
    
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter {

    @XmlAttribute // Προσθήκη του ID ως XML attribute
    private int id;
    @XmlElement(name = "paragraph")
    private List<Paragraph> paragraphs = new ArrayList<>();
}
