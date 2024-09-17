package com.eu.codehub.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Paragraph {

    private List<Sentence> sentences = new ArrayList<>();
}
