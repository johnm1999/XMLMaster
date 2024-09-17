package com.eu.codehub.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
public class Book {

    private List<Chapter> chapters = new ArrayList<>();
    private Statistics statistics;

}
