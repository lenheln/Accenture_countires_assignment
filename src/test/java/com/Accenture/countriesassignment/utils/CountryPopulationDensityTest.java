package com.Accenture.countriesassignment.utils;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import com.Accenture.countriesassignment.domain.country.utils.CountryPopulationDensity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryPopulationDensityTest {

    @Autowired
    CountryPopulationDensity density;

    private BaseCountry c;

    @BeforeEach
    public void init() {
        c = new BaseCountry();
        c.setPopulation(8917205);
        c.setArea(83871.0); //106.3
    }

    @Test
    public void return_0_whenAreaIsZero() {
        c.setArea(0d);
        Double d = density.count(c);
        Assertions.assertEquals(0d, d);
    }

    @Test
    public void return_0_whenAreaIsNull() {
        c.setArea(null);
        Double d = density.count(c);
        Assertions.assertEquals(0d, d);
    }

    @Test
    public void return_0_whenPopulationIsNull() {
        c.setPopulation(null);
        Double d = density.count(c);
        Assertions.assertEquals(0d, d);
    }
}
