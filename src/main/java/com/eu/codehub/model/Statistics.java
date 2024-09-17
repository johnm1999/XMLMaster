/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eu.codehub.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Statistics {

    private int paragraphCount;
    private int sentenceCount;
    private int wordCount;
    private int distinctWordCount;
    private String creationDate;
    private String authorName;
    private String className;
}
