package com.eu.codehub.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Sentence {

    private String text;

    public Sentence(String text) {
        this.text = text;
    }
}
