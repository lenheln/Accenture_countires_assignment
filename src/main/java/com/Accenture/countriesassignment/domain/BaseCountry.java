package com.Accenture.countriesassignment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class BaseCountry {

    private CountryName name;
    private long population;
    private double area;
    private String region;
    private String cca3;
    private List<String> borders;

    public double getDensity() {
        return population/area;
    }

    @Override
    public String toString() {
        return "entities.Country{" +
                "name='" + name + '\'' +
                "density = " + getDensity() +
                '}';
    }
}
