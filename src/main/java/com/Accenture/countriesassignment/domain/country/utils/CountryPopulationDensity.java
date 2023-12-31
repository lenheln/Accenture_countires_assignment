package com.Accenture.countriesassignment.domain.country.utils;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import org.springframework.stereotype.Component;

@Component
public class CountryPopulationDensity {

    public Double count(BaseCountry country) {
        if((country.getPopulation() != null)
                && (country.getArea() != null)
                &&((country.getArea() != 0d))) {
                return country.getPopulation() / country.getArea();
        }
        return 0d;
    }
}
