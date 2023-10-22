package com.Accenture.countriesassignment.domain.country;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class Car {
    private List<String> signs;
    private String side;
}
