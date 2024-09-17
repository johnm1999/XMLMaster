/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eu.codehub.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement
    private int paragraphCount;
    @XmlElement
    private int sentenceCount;
    @XmlElement
    private int wordCount;
    @XmlElement
    private int distinctWordCount;
    @XmlElement
    private String creationDate;
    @XmlElement
    private String authorName;
    @XmlElement
    private String className;
}
