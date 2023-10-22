package com.Accenture.countriesassignment.domain.country;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Idd {
    private String root;
    private List<String> suffixes;
}


